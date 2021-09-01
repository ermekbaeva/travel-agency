package TravelAgency.Entity;

import TravelAgency.Dao.DataTransferObject;

import java.time.LocalDate;
import java.util.List;


public class Tours implements DataTransferObject {
    private int tourID;
    private String country;
    private double price;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private String hotelName;
    private int freePlaces;
    private List<Reservations> reserve;

    public Tours(){
    }

    @Override
    public long getId() {
        return this.getTourID();
    }

    public int getTourID() {
        return tourID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(int freePlaces) {
        this.freePlaces = freePlaces;
    }

    @Override
    public String toString() {
        return  "Tour ID: " + tourID +
                "   |   country: " + country +
                "   |   price: " + price +
                "   |   departure date: " + departureDate +
                "   |   arrival date: " + arrivalDate +
                "   |   hotel name: " + hotelName +
                "   |   free places: " + freePlaces;
    }


}
