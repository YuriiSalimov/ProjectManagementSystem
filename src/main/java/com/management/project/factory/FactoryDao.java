package com.management.project.factory;

import com.management.project.connections.ConnectionMySql;
import com.management.project.dao.*;
import com.management.project.dao.jdbc.*;

import java.sql.SQLException;

/**
 * Created by Slava on 06.03.2017.
 */
public final class FactoryDao {
    private static CompanyDAO companyDAO;
    private static CustomerDAO customerDAO;
    private static DeveloperDAO developerDAO;
    private static ProjectDAO projectDAO;
    private static SkillDAO skillDAO;


    private FactoryDao() {
    }

    public static CompanyDAO getCompanyDAO() throws SQLException {
        if (companyDAO == null) {
            companyDAO = createCompanyDao();
        }
        return companyDAO;
    }

    private static CompanyDAO createCompanyDao() throws SQLException {
        return new JdbcCompanyDAO(ConnectionMySql.getInstance());
    }

    public static CustomerDAO getCustomerDAO() throws SQLException {
        if (customerDAO == null) {
            customerDAO = createCustomerDao();
        }
        return customerDAO;
    }

    private static CustomerDAO createCustomerDao() throws SQLException {
        return new JdbcCustomerDAO(ConnectionMySql.getInstance().getConnection());
    }

    public static DeveloperDAO getDeveloperDAO() throws SQLException {
        if (developerDAO == null) {
            developerDAO = createDeveloperDao();
        }
        return developerDAO;
    }

    private static DeveloperDAO createDeveloperDao() throws SQLException {
        return new JdbcDeveloperDao(ConnectionMySql.getInstance());
    }

    public static ProjectDAO getProjectDAO() throws SQLException {
        if (projectDAO == null) {
            projectDAO = createProjectDao();
        }
        return projectDAO;
    }

    private static ProjectDAO createProjectDao() throws SQLException {
        return new JdbcProjectDAO(ConnectionMySql.getInstance().getConnection());
    }

    public static SkillDAO getSkillDAO() throws SQLException {
        if (skillDAO == null) {
            skillDAO = createSkillDao();
        }
        return skillDAO;
    }

    private static SkillDAO createSkillDao() throws SQLException {
        return new JdbcSkillDAO(ConnectionMySql.getInstance());
    }
}
