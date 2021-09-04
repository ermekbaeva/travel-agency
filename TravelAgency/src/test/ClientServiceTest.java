package test;

import TravelAgency.Connection.DBConnection;
import TravelAgency.Dao.jdbc.JdbcClientsDao;
import TravelAgency.Entity.Clients;
import TravelAgency.Service.ClientService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientServiceTest {
    private static Clients testClient;
    private final static String CORRECT_USER_EMAIL = "meerim@gmail.com";
    private final static String CORRECT_USER_PASSWORD = "1234";
    private final static String TEST_USER_FIRST_NAME = "somebody";
    private final static String TEST_USER_LAST_NAME = "lastname";
    private final static String TEST_USER_EMAIL = "somebody@gmail.com";
    private final static String TEST_USER_PASSWORD = "1111";

    final static ClientService clientService = new ClientService(new JdbcClientsDao(DBConnection.getConnection()));
    @BeforeAll
    public static void init(){
        createTestClient();
    }

    @AfterAll
    public static void close(){
        try{
            clientService.deleteClient(TEST_USER_EMAIL);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testFindCurrentClient() {
        assertTrue(clientService.checkEmailInDB(CORRECT_USER_EMAIL));
    }

    private static void createTestClient(){
        clientService.addClient(TEST_USER_FIRST_NAME, TEST_USER_LAST_NAME,TEST_USER_EMAIL,TEST_USER_PASSWORD);
    }

    @Test
    public void testFindAddedClient() {
        ClientService clientService = new ClientService(new JdbcClientsDao(DBConnection.getConnection()));
        assertTrue(clientService.checkEmailInDB(TEST_USER_EMAIL));
    }
}
