package TravelAgency.Connection;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/travelagency";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;


    public static Connection getConnection(){
        if (connection == null){
            try{
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException ex){
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return connection;
    }
}

