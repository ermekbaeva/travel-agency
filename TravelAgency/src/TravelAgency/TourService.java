package TravelAgency;

import java.sql.Connection;

public class TourService {
    static Connection connection;

    private DataAccessObject<Tours> accessObject;

    public TourService(DataAccessObject<Tours> accessObject){
        this.accessObject = accessObject;
    }

    public String getAllTours(){
        return accessObject.getAll();
    }
}
