package TravelAgency.Dao.jdbc;

import TravelAgency.Dao.GenericDao;
import TravelAgency.Entity.Reservations;

import java.sql.*;

public class JdbcReservationsDao extends GenericDao<Reservations> {

    private static final String SELECT_ALL = "SELECT * FROM reservation";
    private static final String INSERT = "INSERT INTO reservation (Id_client, Id_tour) VALUES(?, ?)";

    public JdbcReservationsDao(Connection connection) {
        super(connection);
    }

    @Override
    public Reservations findById(long id) {
        return null;
    }

    @Override
    public String getAll() {
        return null;
    }

    @Override
    public boolean CheckEmailInDB(String email) {
        return false;
    }

    @Override
    public String filterByCountry(String country) {
        return null;
    }

    @Override
    public String filterByPrice(int min, int max) {
        return null;
    }

    @Override
    public Reservations update(Reservations toUpdate) {
        return null;
    }

    @Override
    public void create(Reservations toCreate) {

    }

    @Override
    public void delete(long id) {

    }

}
