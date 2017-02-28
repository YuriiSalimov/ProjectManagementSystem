package main.java.com.management.project.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Вадим on 28.02.2017.
 */
public class MySQLConnection implements ConnectionDB {

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DB_URL = "jdbc:mysql://localhost:3306/projectManagementDB?autoReconnect=true&useSSL=false";

    private static MySQLConnection mySQLConnection;

    static {

        try {
                Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver is loading");
        } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

    }

    public static MySQLConnection getInstance() {
        if(mySQLConnection == null) {
            mySQLConnection = new MySQLConnection();
        }
        return mySQLConnection;
    }

    @Override
    public Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        System.out.println("connection is good");
        return connection;

    }

}
