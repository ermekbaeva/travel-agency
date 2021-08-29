package TravelAgency;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ToursDao {
    private static final String INSERT = "INSERT INTO tours (FirstName, LastName, Email) VALUES(?, ?, ?)";
  //  private static final String SELECT_BY_EMAIL = "SELECT * FROM tours";
    private static final String SELECT_ALL = "SELECT * FROM tours";

    public Clients findByEmail() {
        Clients client = new Clients();
        Savepoint savepoint = null;

        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                client.setFirstName(resultSet.getString("first_name"));
                client.setFirstName(resultSet.getString("last_name"));
                client.setFirstName(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;

    }

    public void addNewTour(){

        try{
            System.out.print("Enter first name: ");
            Scanner scanner = new Scanner(System.in);
            String firstName = scanner.nextLine();

            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            PreparedStatement statement = DBConnection.getConnection().prepareStatement(INSERT);

                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, email);
                statement.executeUpdate();
                statement.close();
                System.out.println("Your account has registered.");
                MainMenu.optionMenu();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean ShowAllTours(String email){

        try{
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(SELECT_ALL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
