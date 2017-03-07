package com.management.project.controllers;

import com.management.project.connections.ConnectionMySql;
import com.management.project.dao.jdbc.JdbcCompanyDAO;
import com.management.project.dao.jdbc.JdbcCustomerDAO;
import com.management.project.dao.jdbc.JdbcDeveloperDao;
import com.management.project.factory.FactoryDao;
import com.management.project.models.Company;
import com.management.project.models.Developer;
import com.management.project.models.Project;

import java.sql.SQLException;

/**
 * Created by Slava on 07.03.2017.
 */
public class MainTest {
    public static void main(String[] args) throws SQLException {

//        JdbcCustomerDAO jdbcCustomerDAO = new JdbcCustomerDAO(ConnectionMySql.getInstance().getConnection());
//        System.out.println(jdbcCustomerDAO.findByName("Eli Lilly & "));

//        JdbcDeveloperDao jdbcDeveloperDao = new JdbcDeveloperDao(ConnectionMySql.getInstance());
//        jdbcDeveloperDao.update(new Developer(11, "ssss", new Company(1, "cc"), new Project(1, null, 111, null, null), 122));


        DeveloperController developerController = new DeveloperController(FactoryDao.getDeveloperDAO());
        developerController.start();

//        JdbcCompanyDAO jdbcCompanyDAO = new JdbcCompanyDAO(ConnectionMySql.getInstance());
//        //System.out.println(jdbcCompanyDAO.findById(2l));
//        System.out.println(jdbcCompanyDAO.findByName("Ciklum"));


    }
}
