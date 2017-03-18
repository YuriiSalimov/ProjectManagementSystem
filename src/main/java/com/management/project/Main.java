package com.management.project;

import com.management.project.controllers.MainController;

import java.sql.SQLException;

/**
 * @author Slava Makhinich
 */
public class Main {
    public static void main(String[] args) {
        try {
            new MainController().start();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Goodbye!");
    }
}
