import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter '1' to add the client");
        System.out.println("Enter '2' to add the tour");
        System.out.println("Enter '3' to add the reservation");
        System.out.println("Enter '4' to print all clients");
        System.out.println("Enter '5' to print all tours");
        System.out.println("Enter '6' to print all reservations");
        System.out.println("Enter '7' to delete the client");
        System.out.println("Enter '8' to delete the tour");
        System.out.println("Enter '9' to delete the reservation");
        System.out.println("for exit press q or Q: ");

        String answer = scanner.nextLine();

        switch (answer){
            case "1":

                break;
            case "2":

                break;
            case "3":

                break;
            case "4":
                printAllClients();
                break;
            case "5":

                break;
            case "6":

                break;
            case "7":

                break;
            case "8":

                break;
            case "9":

                break;
            default:
                break;
        }
        DBTravelAgency db = new DBTravelAgency();
        //db.addNewClient();
        //db.describeTableClients(answer);
    }

    static void printAllClients(){

    }
}
