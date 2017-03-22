package com.management.project.controllers;

import com.management.project.dao.ProjectDAO;
import com.management.project.factory.FactoryDao;
import com.management.project.models.Company;
import com.management.project.models.Customer;
import com.management.project.models.Project;
import org.junit.Test;
import java.lang.String;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Катя on 19.03.2017.
 */
public class ProjectControllerTest extends AbstractProjectControllerTest {

    private static ProjectDAO projectDAO;

    private AbstractModelController abstractModelController;
    @Test
    public void printMenu() throws SQLException {
        try {
            String menu = "ACTIONS WITH PROJECTS:";
            ProjectController projectController = new ProjectController(projectDAO);
            projectController.printMenu();
            assertTrue(menu.contains(output.toString()));
        } catch(SQLException e){ System.out.println("SQLException ERROR");}
    }


    @Test
    public void getNewModel(){

        Project projectTest = new Project(1, "Android app", 3000, new Company(1, "Luxsoft"),
                new Customer(1, "Bayer"));
        int testId=1;
        String testName= "Android app";
        int testCost = 3000;
        Company testCompany = new Company(1, "Luxsoft");
        Customer testCustomer = new Customer(1, "Bayer");
        projectTest.setId(testId);
        projectTest.setName(testName);
        projectTest.setCost(testCost);
        projectTest.setCompany(testCompany);
        projectTest.setCustomer(testCustomer);
        assertNotNull(projectTest);
        assertEquals(projectTest.getId(), testId);
        assertEquals(projectTest.getName(), testName);
        assertEquals(projectTest.getCost(), testCost);
        assertEquals(projectTest.getCompany(), testCompany);
        assertEquals(projectTest.getCustomer(), testCustomer);

    }

}
