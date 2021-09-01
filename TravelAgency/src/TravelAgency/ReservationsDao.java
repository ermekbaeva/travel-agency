package TravelAgency;

import java.sql.*;

public class ReservationsDao extends  DataAccessObject<Reservations>{

    private static final String SELECT_ALL = "SELECT * FROM reservation";
    private static final String INSERT = "INSERT INTO reservation (Id_client, Id_tour) VALUES(?, ?)";

    public ReservationsDao(Connection connection) {
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
    public Reservations update(Reservations toUpdate) {
        return null;
    }

    @Override
    public void create(Reservations toCreate) {

    }

    @Override
    public void delete(long id) {

    }

    /*public Reservations getAllReservations() {
        Reservations reserve = new Reservations();
        Savepoint savepoint = null;

        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                reserve.setClientID(resultSet.getInt("Id_client"));
                reserve.setTourID(resultSet.getInt("Id_tour"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reserve;

    }

    public void addNewReservation(){

        try{
            System.out.print("Enter country of tour: ");
            Scanner scanner = new Scanner(System.in);
            String country = scanner.nextLine();


            PreparedStatement statement = DBConnection.getConnection().prepareStatement(INSERT);

            *//*statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.executeUpdate();
            statement.close();*//*
            System.out.println("Your account has registered.");
            MainMenu.optionMenu();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }*/


}
