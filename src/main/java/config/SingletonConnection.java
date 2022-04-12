package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

    public static final String SQL_URL = "jdbc:mysql://localhost:3306/product_manager";
    public static final String SQL_USER = "root";
    public static final String SQL_PASSWORD = "Giangpro123";

    private SingletonConnection() {
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
