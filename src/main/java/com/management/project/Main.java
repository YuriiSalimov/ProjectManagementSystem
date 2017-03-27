package com.management.project;

import com.management.project.controllers.AbstractController;
import com.management.project.controllers.MainController;
import com.management.project.factory.FactoryController;
import com.management.project.factory.HibFactoryController;

import java.sql.SQLException;

/**
 * @author Slava Makhinich
 */
public class Main extends AbstractController {

    public static void main(String[] args) {
        try {
            new Main().start();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Goodbye!");
    }

    @Override
    protected void action(int choice) throws SQLException {
        switch (choice) {
        case 1:
            new MainController(FactoryController.getCompanyController(),
                    FactoryController.getCustomerController(),
                    FactoryController.getDeveloperController(),
                    FactoryController.getProjectController(),
                    FactoryController.getSkillController())
                    .start();
            break;
        case 2:
            new MainController(HibFactoryController.getCompanyController(),
                    HibFactoryController.getCustomerController(),
                    HibFactoryController.getDeveloperController(),
                    HibFactoryController.getProjectController(),
                    HibFactoryController.getSkillController())
                    .start();
            break;
        }
    }

    @Override
    protected void printMenu() {
        System.out.println("What DAO do you want to use?");
        System.out.println("1- JDBC DAO");
        System.out.println("2- Hibernate DAO");
        System.out.println("0- exit");
    }
}
