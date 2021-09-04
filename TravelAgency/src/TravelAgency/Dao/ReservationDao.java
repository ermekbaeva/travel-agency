package TravelAgency.Dao;

import java.sql.Connection;

public abstract class ReservationDao<T extends DataTransferObject>{
    protected final Connection connection;

    public ReservationDao(Connection connection) {
        this.connection = connection;
    }

    public abstract String getAll(String email);

    public abstract void create(String email, String country, int price);

    public abstract void delete(String email, String country, int price);
}
