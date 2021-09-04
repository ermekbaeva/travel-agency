package TravelAgency.Entity;

import TravelAgency.Dao.DataTransferObject;

public class Reservations implements DataTransferObject {
    private int reservationID;
    private int clientID;
    private int tourID;
    private String emailClient;
    private String countryTour;
    private int price;

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Reservations(){

    }

    public int getReservationID() {
        return reservationID;
    }


    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getTourID() {
        return tourID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    @Override
    public String toString() {
        return "reservation ID: " + reservationID +
                "   |   client ID: " + clientID +
                "   |   tour ID: " + tourID +
                "   |   client's email: " + emailClient+
                "   |   country tour: " + countryTour+
                "   |   price: " + price;
    }

    @Override
    public long getId() {
        return 0;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getCountryTour() {
        return countryTour;
    }

    public void setCountryTour(String countryTour) {
        this.countryTour = countryTour;
    }
}
