package dao;

import model.Customer;

/**
 * Created by Perevoznyk Pavel on 20.02.2017.
 * V 1.0a
 */
public interface CustomerDAO extends GenericDAO<Customer, Long> {
    Customer findCustomerByName(String name);
}
