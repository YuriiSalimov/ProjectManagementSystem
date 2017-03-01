package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Pavel on 28.02.2017.
 */
public class test {
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementdb", "root", "root")){

        }
    }
}
