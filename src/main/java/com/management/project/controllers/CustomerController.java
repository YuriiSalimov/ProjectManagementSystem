package com.management.project.controllers;

import com.management.project.dao.GenericDAO;
import com.management.project.models.Customer;

/**
 * just a frame, need to fill
 */
public class CustomerController extends AbstractModelController<Customer> {

    public CustomerController(GenericDAO<Customer, Long> dao) {
        super(dao);
    }

    @Override
    protected Customer getNewModel() {
        return null;
    }
}
