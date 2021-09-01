package TravelAgency;

import TravelAgency.Connection.DBConnection;
import TravelAgency.Dao.jdbc.JdbcClientsDao;
import TravelAgency.Dao.jdbc.JdbcToursDao;
import TravelAgency.Service.ClientService;
import TravelAgency.Service.TourService;

import java.sql.Connection;
import java.util.Scanner;

public class MainMenu {
    static Scanner scanner = new Scanner(System.in);
    static Connection connection;

    public static void main(String[] args) {
        menu();
    }
    static void optionMenu(){
        TourService tours = new TourService(new JdbcToursDao(DBConnection.getConnection()));
        System.out.println("Choose the option: ");
        System.out.println();
        System.out.println("1. See all tours");
        System.out.println("2. Filter tours by price");
        System.out.println("3. Filter tours by country");
        System.out.println("4. Reserve the tour");
        System.out.println("5. Cancel the tour");
        System.out.println("6. See my reservations");
        System.out.println("Write 'quit' for exit: ");

        String answer = scanner.nextLine();

        switch (answer){
            case "1":
                System.out.println(tours.getAllTours());
                optionMenu();
                break;
            case "2":
                System.out.println(tours.filterByPrice());
                optionMenu();
                break;
            case "3":
                System.out.println(tours.filterByCountry());
                optionMenu();
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
        final ClientService clientService = new ClientService(new JdbcClientsDao(DBConnection.getConnection()));
        JdbcClientsDao cl = new JdbcClientsDao(connection);

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
                if (clientService.checkEmailInDB(email)){
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
