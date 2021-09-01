package TravelAgency;

import java.sql.*;

public class ToursDao extends DataAccessObject<Tours>{

    private static final String SELECT_ALL = "SELECT * FROM tours";
    private static final String FILTER_BY_COUNTRY = "SELECT Id_tour, Country, Price, Departure_date, Arrival_date, Hotel_name, Free_places FROM tours WHERE Country = ?";
    private static final String FILTER_BY_PRICE = "SELECT Id_tour, Country, Price, Departure_date, Arrival_date, Hotel_name, Free_places FROM tours WHERE Price BETWEEN ? AND ?";

    public ToursDao(Connection connection) {
        super(connection);
    }

    @Override
    public Tours findById(long id) {
        return null;
    }

    @Override
    public String getAll() {
        Tours tour = new Tours();
        StringBuilder allTours = new StringBuilder();
        try {
            PreparedStatement statement = this.connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                tour.setTourID(resultSet.getInt("Id_tour"));
                tour.setCountry(resultSet.getString("Country"));
                tour.setPrice(resultSet.getDouble("Price"));
                tour.setDepartureDate((resultSet.getDate("Departure_date").toLocalDate()));
                tour.setArrivalDate((resultSet.getDate("Arrival_date").toLocalDate()));
                tour.setHotelName(resultSet.getString("Hotel_name"));
                tour.setFreePlaces(resultSet.getInt("Free_places"));
                allTours.append(tour.toString()+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return String.valueOf(allTours);
    }

    @Override
    public boolean CheckEmailInDB(String email) {
        return false;
    }

    @Override
    public String filterByCountry(String country) {
        Tours tour = new Tours();
        StringBuilder allTours = new StringBuilder();
        try {
            PreparedStatement statement = this.connection.prepareStatement(FILTER_BY_COUNTRY);
            statement.setString(1, country);
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                tour.setTourID(resultSet.getInt("Id_tour"));
                tour.setCountry(resultSet.getString("Country"));
                tour.setPrice(resultSet.getDouble("Price"));
                tour.setDepartureDate((resultSet.getDate("Departure_date").toLocalDate()));
                tour.setArrivalDate((resultSet.getDate("Arrival_date").toLocalDate()));
                tour.setHotelName(resultSet.getString("Hotel_name"));
                tour.setFreePlaces(resultSet.getInt("Free_places"));
                allTours.append(tour.toString()+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return String.valueOf(allTours);
    }

    @Override
    public String filterByPrice(int min, int max) {
        Tours tour = new Tours();
        StringBuilder allTours = new StringBuilder();
        try {
            PreparedStatement statement = this.connection.prepareStatement(FILTER_BY_PRICE);
            ResultSet resultSet = statement.executeQuery();
            statement.setInt(1, min);
            statement.setInt(2, max);

            while (resultSet.next()) {
                tour.setTourID(resultSet.getInt("Id_tour"));
                tour.setCountry(resultSet.getString("Country"));
                tour.setPrice(resultSet.getDouble("Price"));
                tour.setDepartureDate((resultSet.getDate("Departure_date").toLocalDate()));
                tour.setArrivalDate((resultSet.getDate("Arrival_date").toLocalDate()));
                tour.setHotelName(resultSet.getString("Hotel_name"));
                tour.setFreePlaces(resultSet.getInt("Free_places"));
                allTours.append(tour.toString()+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return String.valueOf(allTours);
    }

    @Override
    public Tours update(Tours toUpdate) {
        return null;
    }

    @Override
    public void create(Tours toCreate) {

    }

    @Override
    public void delete(long id) {

    }

}
