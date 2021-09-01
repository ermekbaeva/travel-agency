package TravelAgency;

import java.sql.Connection;
import java.util.Scanner;

public class MainMenu {
    static Scanner scanner = new Scanner(System.in);
    static Connection connection;

    public static void main(String[] args) {
        menu();
    }
    static void optionMenu(){
        TourService tours = new TourService(new ToursDao(DBConnection.getConnection()));
        System.out.println("Choose the option: ");
        System.out.println();
        System.out.println("1. See all tours");
        System.out.println("2. Reserve the tour");
        System.out.println("3. Cancel the tour");
        System.out.println("4. Filter tours by price");
        System.out.println("5. Filter tours by country");
        System.out.println("6. See my reservations");
        System.out.println("write 'quit' for exit: ");

        String answer = scanner.nextLine();

        switch (answer){
            case "1":
                System.out.println(tours.getAllTours());
                break;
            case "2":
              //  addTour();
                break;
            case "3":
              //  addReservation();
                break;
            case "4":
             //   printAllClients();
                break;
            case "5":
             //   printAllTours();
                break;
            case "6":
              //  printAllReservations();
                break;
            case "quit":
                break;
            default:
                System.out.println("Enter number to choose the option!");
                optionMenu();
                break;
        }
    }
    static void menu(){
        final ClientService clientService = new ClientService(new ClientsDao(DBConnection.getConnection()));
        ClientsDao cl = new ClientsDao(connection);

        System.out.println("************************************");
        System.out.println("      Welcome to Travel Agency      ");
        System.out.println("************************************");
        System.out.println();
        System.out.println("Already have an account? Y/N \nEnter quit to exit");
        System.out.println();
        String answer = scanner.nextLine();
        switch (answer){
            case "Y":
                System.out.print("Enter your email: ");
                String email = scanner.nextLine();
                if (cl.CheckEmailInDB(email) == true){
                    optionMenu();
                    break;
                }else{
                    System.out.println("Email has not found.");
                    System.out.println("--------------------");
                    menu();
                    break;
                }
            case "N":
                clientService.addClient();
            case "quit":
                break;
            default:
                System.out.println("Enter Y/N to enter the menu!");
                System.out.println("----------------------------");
                menu();
                break;
        }


    }
}
