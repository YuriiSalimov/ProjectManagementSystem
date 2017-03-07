package com.management.project.controllers;

import com.management.project.dao.CompanyDAO;
import com.management.project.dao.CustomerDAO;
import com.management.project.dao.GenericDAO;
import com.management.project.dao.ProjectDAO;
import com.management.project.factory.FactoryDao;
import com.management.project.models.Company;
import com.management.project.models.Customer;
import com.management.project.models.Model;
import com.management.project.models.Project;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Slava on 07.03.2017.
 */
public class ProjectController extends AbstractModelController {

    protected CompanyDAO companyDAO = FactoryDao.getCompanyDAO();
    protected CustomerDAO customerDAO = FactoryDao.getCustomerDAO();

    public ProjectController(ProjectDAO dao) throws SQLException {
        super(dao);
    }

    @Override
    protected void printMenu() {
        System.out.println();
        System.out.println("Actions with project:");
        super.printMenu();
    }

    @Override
    protected Model getNewModel() {

        System.out.print("Input project name: ");
        String projectName = new Scanner(System.in).nextLine();
        System.out.print("Input project cost: ");
        int projectCost = new Scanner(System.in).nextInt();
        System.out.print("Input company id: ");
        long companyId = new Scanner(System.in).nextLong();
        System.out.print("Input customer id: ");
        long customerId = new Scanner(System.in).nextLong();
        Company company = new Company(companyId, "bla-bla"); //companyDAO.findById(companyId);   -- эаменить когда допшут JdbcCompanyDAO
        Customer customer = customerDAO.findById(customerId);
        Project project = new Project(-100, projectName, projectCost, company, customer);
        return project;
    }
}
