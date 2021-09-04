package TravelAgency.Dao.jdbc;

import TravelAgency.Connection.DBConnection;
import TravelAgency.Dao.ClientDao;
import TravelAgency.Entity.Clients;
import TravelAgency.MainMenu;

import java.sql.*;
import java.util.Locale;

public class JdbcClientsDao extends ClientDao<Clients> {
    private static final String INSERT = "INSERT INTO clients (FirstName, LastName, Email, Password) VALUES(?, ?, ?, ?)";
    private static final String SELECT_BY_EMAIL = "SELECT * FROM clients WHERE email = ?";
    private static final String SELECT_BY_PASSWORD = "SELECT * FROM clients WHERE password = ?";
    private static final String SELECT_ALL = "SELECT * FROM clients";
    private static final String DELETE_BY_EMAIL = "DELETE FROM clients WHERE email = ?";

    public JdbcClientsDao(Connection connection) {
        super(connection);
    }

    @Override
    public Clients findById(long id) {
        return null;
    }

    @Override
    public String getAll() {
        Clients client = new Clients();
        StringBuilder allClients = new StringBuilder();
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                client.setFirstName(resultSet.getString("first_name"));
                client.setFirstName(resultSet.getString("last_name"));
                client.setFirstName(resultSet.getString("email"));
                client.setFirstName(resultSet.getString("password"));
                allClients.append(client.toString()+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return String.valueOf(allClients);
    }


    @Override
    public Clients update(Clients toUpdate) {
        return null;
    }

    @Override
    public void create(Clients toCreate) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(INSERT);

                statement.setString(1, toCreate.getFirstName());
                statement.setString(2, toCreate.getLastName());
                statement.setString(3, toCreate.getEmail());
                statement.setString(4, toCreate.getPassword());
                statement.executeUpdate();
                statement.close();
                System.out.println("Your account has registered.");
                System.out.println("----------------------------");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void delete(String email) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(DELETE_BY_EMAIL);

            statement.setString(1, email);
            statement.executeUpdate();
            statement.close();
            System.out.println("Account has deleted.");
            System.out.println("--------------------");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean CheckEmailInDB(String email) {

        try {
            PreparedStatement statement = this.connection.prepareStatement(SELECT_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean checkPasswordInDB(String password) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(SELECT_BY_PASSWORD);
            statement.setString(1, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
