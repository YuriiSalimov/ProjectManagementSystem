package com.management.project.controllers;

import com.management.project.dao.GenericDAO;
import com.management.project.models.Company;

import java.util.Scanner;

/**
 * DESCRIPTION - ???
 *
 * @author Вадим
 */
public class CompanyController extends AbstractModelController<Company> {

    /**
     *
     * @param dao
     */
    public CompanyController(GenericDAO<Company, Long> dao) {
        super(dao);
    }

    /**
     *
     * @return
     */
    @Override
    protected Company getNewModel() {
        System.out.print("Input company name: ");
        String companyName = new Scanner(System.in).nextLine();
        return new Company(-100, companyName);
    }

    /**
     *
     */
    @Override
    protected void printMenu() {
        System.out.println();
        System.out.println("ACTIONS WITH COMPANIES:");
        super.printMenu();
    }
}
