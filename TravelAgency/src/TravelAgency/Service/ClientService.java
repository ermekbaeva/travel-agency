package TravelAgency.Service;


import TravelAgency.Dao.GenericDao;
import TravelAgency.Entity.Clients;

import java.util.Scanner;

public class ClientService {


    private GenericDao<Clients> accessObject;

    public ClientService(GenericDao<Clients> accessObject){
        this.accessObject = accessObject;
    }

    public void addClient(){
        System.out.print("Enter first name: ");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

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

}
