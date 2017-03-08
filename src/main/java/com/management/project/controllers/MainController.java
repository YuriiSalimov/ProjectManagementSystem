package com.management.project.controllers;

import com.management.project.factory.FactoryController;

import java.sql.SQLException;

/**
 * @author Slava Makhinich
 */
public class MainController extends AbstractController {

    private final CompanyController companyController = FactoryController.getCompanyController();
    private final CustomerController customerController = FactoryController.getCustomerController();
    private final DeveloperController developerController = FactoryController.getDeveloperController();
    private final ProjectController projectController = FactoryController.getProjectController();
    private final SkillController skillController = FactoryController.getSkillController();

    public MainController() throws SQLException {
    }

    @Override
    protected void action(int choice) {
        switch (choice) {
            case 1:
                companyController.start();
                break;
            case 2:
                customerController.start();
                break;
            case 3:
                developerController.start();
                break;
            case 4:
                projectController.start();
                break;
            case 5:
                skillController.start();
                break;
        }
    }

    @Override
    protected void printMenu() {
        System.out.println("MAIN MENU");
        System.out.println("1- actions with companies");
        System.out.println("2- actions with customers");
        System.out.println("3- actions with developers");
        System.out.println("4- actions with projects");
        System.out.println("5- actions with skills");
        System.out.println("0- exit");
    }
}
