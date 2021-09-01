package TravelAgency;

import java.sql.Connection;

public abstract class DataAccessObject <T extends DataTransferObject>{
    protected final Connection connection;

    public DataAccessObject(Connection connection) {
        this.connection = connection;
    }

    public abstract T findById(long id);

    public  abstract String getAll();

    public abstract T update(T toUpdate);

    public abstract void create(T toCreate);

    public abstract void delete(long id);
}
