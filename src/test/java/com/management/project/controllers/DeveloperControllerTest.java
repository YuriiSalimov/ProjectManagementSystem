package com.management.project.controllers;

import com.management.project.dao.CompanyDAO;
import com.management.project.dao.GenericDAO;
import com.management.project.dao.ProjectDAO;
import com.management.project.dao.SkillDAO;
import com.management.project.models.Company;
import com.management.project.models.Customer;
import com.management.project.models.Developer;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by Вадим on 21.03.2017.
 */
public class DeveloperControllerTest extends AbstractModelControllerTest {

    GenericDAO dao = mock(GenericDAO.class);
    SkillDAO skillDAO = mock(SkillDAO.class);
    CompanyDAO companyDAO = mock(CompanyDAO.class);
    ProjectDAO projectDAO = mock(ProjectDAO.class);
    DeveloperController developerController = new DeveloperController(dao,skillDAO,companyDAO,projectDAO);
    @Test
    public void printMenu() throws Exception {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        developerController.printMenu();
        assertTrue(byteArrayOutputStream.toString().contains("ACTIONS WITH DEVELOPERS:"));
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

    }

    @Test
    public void getNewModel() throws Exception {

        System.setIn(new ByteArrayInputStream(("name").getBytes()));
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        System.setIn(new ByteArrayInputStream("0".getBytes()));
        scanner.nextInt();
        scanner.next();
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        scanner.next();
        scanner.nextInt();
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        scanner.next();
        System.setIn(new ByteArrayInputStream("null".getBytes()));
        scanner.close();
        Developer developer = developerController.getNewModel();
        assertEquals(developer, new Developer("name", companyDAO.findById(1L), projectDAO.findById(1L),0,null));
    }

}