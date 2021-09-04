package TravelAgency.Dao;

import java.sql.Connection;

public abstract class ClientDao<T extends DataTransferObject>{
    protected final Connection connection;

    public ClientDao(Connection connection) {
        this.connection = connection;
    }

    public abstract T findById(long id);

    public abstract String getAll();

    public abstract boolean CheckEmailInDB(String email);

    public abstract boolean checkPasswordInDB(String password);

    public abstract T update(T toUpdate);

    public abstract void create(T toCreate);

    public abstract void delete(long id);
}
