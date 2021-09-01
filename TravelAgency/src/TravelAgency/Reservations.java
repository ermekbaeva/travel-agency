package TravelAgency;

public class Reservations implements DataTransferObject{
    private int reservationID;
    private int clientID;
    private int tourID;

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
        return "Reservations{" +
                "reservationID=" + reservationID +
                ", clientID=" + clientID +
                ", tourID=" + tourID +
                '}';
    }

    @Override
    public long getId() {
        return 0;
    }
}
