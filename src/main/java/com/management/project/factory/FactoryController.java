package com.management.project.factory;

import com.management.project.controllers.*;
import com.management.project.dao.SkillDAO;

import java.sql.SQLException;

/**
 * @author Slava Makhinich
 */
public class FactoryController {
    private static CompanyController companyController;
    private static CustomerController customerController;
    private static DeveloperController developerController;
    private static ProjectController projectController;
    private static SkillController skillController;

    private FactoryController(){
    }

    public static CompanyController getCompanyController() throws SQLException {
        if (companyController == null) {
            companyController = new CompanyController(FactoryDao.getCompanyDAO());
        }
        return companyController;
    }

    public static CustomerController getCustomerController() throws SQLException {
        if (customerController == null) {
            customerController = new CustomerController(FactoryDao.getCustomerDAO());
        }
        return customerController;
    }

    public static DeveloperController getDeveloperController() throws SQLException {
        if (developerController == null) {
            developerController = new DeveloperController(FactoryDao.getDeveloperDAO());
        }
        return developerController;
    }

    public static ProjectController getProjectController() throws SQLException {
        if (projectController == null) {
            projectController = new ProjectController(FactoryDao.getProjectDAO());
        }
        return projectController;
    }

    public static SkillController getSkillController() throws SQLException {
        if (skillController == null) {
            skillController = new SkillController(FactoryDao.getSkillDAO());
        }
        return skillController;
    }
}
