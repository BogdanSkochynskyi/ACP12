package week6;

import java.sql.*;

/**
 * Created by gavri on 25.03.2016.
 */
public class IntroJDBC {

    public static final String URL = "jdbc:mysql://localhost:3306/homework6";
    public static final String USER = "root";
    public static final String PASSWORD = "admin";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection =
                    DriverManager.
                            getConnection(URL, USER, PASSWORD)) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * FROM movies");
            int i = 0;
            while (resultSet.next()){
                System.out.println(resultSet.getInt("mID") +" "+ resultSet.getString("title")+" "+resultSet.getString("year"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
