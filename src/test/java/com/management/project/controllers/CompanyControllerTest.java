package com.management.project.controllers;

import com.management.project.models.Company;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;
/**
 * Created by Misha on 17.03.2017.
 */
public class CompanyControllerTest extends AbstractCompanyControllerTest {

   private Company company;

   private AbstractModelController abstractModelController;


    @Test
    public void getNewModel(){
     String testName = new Scanner(System.in).nextLine();
        Company testCompany = new Company();
        testCompany.setName(testName);
        assertNotNull(testCompany);
        assertEquals(testCompany.getName(), testName);
    }



    @Test
    public void printMenu() {
        String menu = "ACTIONS WITH COMPANIES:";
        CompanyController companyController = null;
        companyController.printMenu();
        assertTrue(menu.contains(output.toString()));
    }


}

