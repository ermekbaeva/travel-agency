package TravelAgency.Dao.jdbc;

import TravelAgency.Dao.ReservationDao;
import TravelAgency.Entity.Reservations;
import TravelAgency.Entity.Tours;

import java.sql.*;

public class JdbcReservationsDao extends ReservationDao<Reservations> {
    private static final String INSERT = "INSERT INTO reservation (Id_client, Id_tour, client_email, tour_country, price) " +
            "SELECT Id_client, Id_tour, email, country, price FROM clients, tours WHERE email=? " +
            "and country = ? and price = ?";
    private static final String SELECT_BY_EMAIL = "SELECT * FROM reservation WHERE client_email = ?";
    private static final String DELETE = "DELETE FROM reservation WHERE client_email=? " +
            "and tour_country = ? and price = ?";

    public JdbcReservationsDao(Connection connection) {
        super(connection);
    }


    @Override
    public String getAll(String email) {
        Reservations reserve = new Reservations();
        StringBuilder allReservations = new StringBuilder();
        try {
            PreparedStatement statement = this.connection.prepareStatement(SELECT_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                reserve.setReservationID(resultSet.getInt("Id_reservation"));
                reserve.setClientID(resultSet.getInt("Id_client"));
                reserve.setTourID(resultSet.getInt("Id_tour"));
                reserve.setEmailClient(resultSet.getString("client_email"));
                reserve.setCountryTour(resultSet.getString("tour_country"));
                reserve.setPrice(resultSet.getInt("price"));
                allReservations.append(reserve.toString()+"\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return String.valueOf(allReservations);
    }


    @Override
    public void create(String email, String country, int price) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(INSERT);

            statement.setString(1, email);
            statement.setString(2, country);
            statement.setInt(3, price);
            statement.executeUpdate();
            statement.close();
            System.out.println("Your tour has reserved.");
            System.out.println("-----------------------");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String email, String country, int price) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(DELETE);

            statement.setString(1, email);
            statement.setString(2, country);
            statement.setInt(3, price);
            statement.executeUpdate();
            statement.close();
            System.out.println("Your tour has canceled.");
            System.out.println("-----------------------");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
