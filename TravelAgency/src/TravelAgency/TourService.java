package TravelAgency;

import java.sql.Connection;
import java.util.Scanner;

public class TourService {
    static Connection connection;

    private DataAccessObject<Tours> accessObject;

    public TourService(DataAccessObject<Tours> accessObject){
        this.accessObject = accessObject;
    }

    public String getAllTours(){
        return accessObject.getAll();
    }

    public String filterByPrice(){
        System.out.print("Enter min price: ");
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();

        System.out.print("Enter min price: ");
        int max = scanner.nextInt();

        return accessObject.filterByPrice(min, max);
    }

    public String filterByCountry(){
        System.out.print("Enter country: ");
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();
        return accessObject.filterByCountry(country);
    }
}
