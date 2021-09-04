package TravelAgency.Service;


import TravelAgency.Dao.ClientDao;
import TravelAgency.Entity.Clients;
import TravelAgency.MainMenu;

import java.util.Scanner;

public class ClientService {


    private ClientDao<Clients> accessObject;

    public ClientService(ClientDao<Clients> accessObject){
        this.accessObject = accessObject;
    }

    public void addClient(String firstName, String lastName, String email, String password){
        Clients newClient = new Clients();
        newClient.setFirstName(firstName);
        newClient.setLastName(lastName);
        newClient.setEmail(email);
        newClient.setPassword(password);


        this.accessObject.create(newClient);

    }
    public boolean checkEmailInDB(String email){
        return this.accessObject.CheckEmailInDB(email);
    }

    public boolean checkPassword(String password){
        return this.accessObject.checkPasswordInDB(password);
    }

    public void deleteClient(String email){
        this.accessObject.delete(email);
    }

}
