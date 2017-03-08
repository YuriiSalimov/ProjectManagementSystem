package com.management.project.dao.jdbc;

import com.management.project.dao.CompanyDAO;
import com.management.project.dao.CustomerDAO;
import com.management.project.dao.ProjectDAO;
import com.management.project.factory.FactoryDao;
import com.management.project.models.Company;
import com.management.project.models.Customer;
import com.management.project.models.Project;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @author Slava Makhinich
 */
public class JdbcProjectDAOTest {

    private ProjectDAO projectDAO = FactoryDao.getProjectDAO();
    private CompanyDAO companyDAO = FactoryDao.getCompanyDAO();
    private CustomerDAO customerDAO = FactoryDao.getCustomerDAO();

    public JdbcProjectDAOTest() throws SQLException {
    }

    @Test
    public void findByName() throws Exception {

        Company company = companyDAO.findById(1l);
        Customer customer = customerDAO.findById(1l);
        Project project = new Project(-1, "newTestProject1111", 3333, company, customer);
        projectDAO.save(project);

        Project project1 = projectDAO.findByName("newTestProject1111");
        assertEquals(project1, project);

        projectDAO.delete(project1);
        assertNull(projectDAO.findByName("newTestProject1111"));
    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void findById() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void findAll() throws Exception {

    }

}