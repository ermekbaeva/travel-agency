package TravelAgency.Service;

import TravelAgency.Dao.TourDao;
import TravelAgency.Entity.Tours;

import java.sql.Connection;
import java.util.Scanner;

public class TourService {
    static Connection connection;

    private TourDao<Tours> accessObject;

    public TourService(TourDao<Tours> accessObject){
        this.accessObject = accessObject;
    }

    public String getAllTours(){
        return accessObject.getAll();
    }

    public String filterByPrice(){
        System.out.print("Enter min price: ");
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();

        System.out.print("Enter max price: ");
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
