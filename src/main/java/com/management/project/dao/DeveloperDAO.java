package com.management.project.dao;

import com.management.project.models.Company;
import com.management.project.models.Customer;
import com.management.project.models.Developer;
import com.management.project.models.Project;

/**
 * DESCRIPTION - ???
 *
 * @author Perevoznyk Pavel
 */
public interface DeveloperDAO extends GenericDAO<Developer, Long> {

    /**
     * The method creates and return a new developer with empty parameters
     *
     * @return a developer with empty parameters
     */
    default Developer createNewEmptyDeveloper() {
        Developer developer = new Developer();
        Customer customer = new Customer(0, "");
        Company company = new Company(0, "");
        Project project = new Project(0, "", 0, company, customer);
        return new Developer(0, "", company, project, 0);
    }

}
