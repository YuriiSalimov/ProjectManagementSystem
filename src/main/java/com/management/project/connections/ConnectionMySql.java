package com.management.project.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Вадим on 28.02.2017.
 */
public class ConnectionMySql implements ConnectionDB {

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DB_URL = "jdbc:mysql://localhost:3306/projectManagementDB?autoReconnect=true&useSSL=false";

    private static ConnectionMySql connectionMySql;

    private ConnectionMySql(){}

    static {

        try {
                Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

    }

    public static ConnectionMySql getInstance() {
        if(connectionMySql == null) {
            connectionMySql = new ConnectionMySql();
        }
        return connectionMySql;
    }

    @Override
    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(DB_URL, USER, PASSWORD);

    }

}
