package com.management.project.controllers;

import com.management.project.dao.GenericDAO;
import com.management.project.models.Company;

/**
 * just a frame, need to fill
 */
public class CompanyController extends AbstractModelController<Company> {

    public CompanyController(GenericDAO<Company, Long> dao) {
        super(dao);
    }

    @Override
    protected Company getNewModel() {
        return null;
    }
}
