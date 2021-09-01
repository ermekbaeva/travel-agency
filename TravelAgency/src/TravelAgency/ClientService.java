package TravelAgency;


import java.util.Scanner;

public class ClientService {


    private DataAccessObject<Clients> accessObject;

    public ClientService(DataAccessObject<Clients> accessObject){
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

}
