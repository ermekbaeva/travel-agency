package TravelAgency.Service;

import TravelAgency.Dao.ClientDao;
import TravelAgency.Dao.ReservationDao;
import TravelAgency.Dao.TourDao;
import TravelAgency.Entity.Clients;
import TravelAgency.Entity.Reservations;

public class ReservationService {
    private ReservationDao<Reservations> accessObject;

    public ReservationService(ReservationDao<Reservations> accessObject){
        this.accessObject = accessObject;
    }

    public void addReservation(String email, String country, int price){
        this.accessObject.create(email, country, price);
    }

    public String getAllReservations(String email){
        return accessObject.getAll(email);
    }

    public void cancelReservation(String email, String country, int price){
        accessObject.delete(email, country, price);
    }
}
