package TravelAgency;

import TravelAgency.Connection.DBConnection;
import TravelAgency.Dao.jdbc.JdbcClientsDao;
import TravelAgency.Dao.jdbc.JdbcReservationsDao;
import TravelAgency.Dao.jdbc.JdbcToursDao;
import TravelAgency.Service.ClientService;
import TravelAgency.Service.ReservationService;
import TravelAgency.Service.TourService;

import java.sql.Connection;
import java.util.Scanner;

public class MainMenu {
    static Scanner scanner = new Scanner(System.in);
    static Connection connection;
    private static String email = null;
    static TourService tours = new TourService(new JdbcToursDao(DBConnection.getConnection()));
    static final ClientService clientService = new ClientService(new JdbcClientsDao(DBConnection.getConnection()));
    static ReservationService reserveService = new ReservationService(new JdbcReservationsDao(DBConnection.getConnection()));
    static String country = null;
    static int price = 0;

    public static void main(String[] args) {
        menu();
    }

    static void optionMenu() {

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

        switch (answer.toLowerCase()) {
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
                System.out.print("Enter tour's country: ");

                String country = scanner.nextLine();

                System.out.print("Enter price: ");
                int price = scanner.nextInt();

                reserveService.addReservation(email, country, price);
                optionMenu();
                break;
            case "5":
                System.out.print("Enter tour's country: ");
                country = scanner.nextLine();

                System.out.print("Enter price: ");
                price = scanner.nextInt();

                reserveService.cancelReservation(email, country, price);
                optionMenu();
                break;
            case "6":
                System.out.println(reserveService.getAllReservations(email));
                optionMenu();
                break;
            case "quit":
                System.exit(0);
            default:
                System.out.println("Enter number to choose the option!");
                optionMenu();
                break;
        }
    }

   public static void menu() {

        System.out.println("************************************");
        System.out.println("      Welcome to Travel Agency      ");
        System.out.println("************************************");
        System.out.println();
        System.out.println("Already have an account? Y/N \nEnter quit to exit");
        System.out.println();

        String answer = scanner.nextLine();
        switch (answer.toLowerCase()) {
            case "y":
                System.out.print("Enter your email: ");
                email = scanner.nextLine();
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();
                if (clientService.checkEmailInDB(email)&&clientService.checkPassword(password)) {
                    optionMenu();
                    break;
                } else {
                    System.out.println("The email or password is incorrect.");
                    System.out.println("-----------------------------------");
                    menu();
                    break;
                }
            case "n":
                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();

                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();

                System.out.print("Enter email: ");
                String email = scanner.nextLine();

                System.out.print("Enter password: ");
                password = scanner.nextLine();
                if (clientService.checkEmailInDB(email)) {
                    System.out.println("This email already exists.");
                    System.out.println("--------------------------");
                    MainMenu.menu();
                } else {
                    clientService.addClient(firstName, lastName, email, password);
                    optionMenu();
                }
            case "quit":
                System.exit(0);
            default:
                System.out.println("Enter Y/N to enter the menu!");
                System.out.println("----------------------------");
                menu();
                break;
        }

    }
}

