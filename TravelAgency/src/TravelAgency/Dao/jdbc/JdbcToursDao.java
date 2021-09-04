package TravelAgency.Dao.jdbc;

import TravelAgency.Dao.TourDao;
import TravelAgency.Entity.Tours;

import java.sql.*;

public class JdbcToursDao extends TourDao<Tours> {

    private static final String SELECT_ALL = "SELECT * FROM tours";
    private static final String FILTER_BY_COUNTRY = "SELECT * FROM tours WHERE Country = ?";
    private static final String FILTER_BY_PRICE = "SELECT * FROM tours WHERE Price BETWEEN ? AND ?";

    public JdbcToursDao(Connection connection) {
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

            statement.setInt(1, min);
            statement.setInt(2, max);
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
