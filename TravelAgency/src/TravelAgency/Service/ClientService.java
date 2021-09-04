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

        if (checkEmailInDB(email)) {
            System.out.println("This email already exists.");
            System.out.println("--------------------------");
            MainMenu.menu();
        } else {
            this.accessObject.create(newClient);
        }
    }
    public boolean checkEmailInDB(String email){
        return this.accessObject.CheckEmailInDB(email);
    }

    public boolean checkPassword(String password){
        return this.accessObject.checkPasswordInDB(password);
    }

}
