package com.management.project.factory;

import com.management.project.connections.ConnectionMySql;
import com.management.project.dao.*;
import com.management.project.dao.jdbc.*;

import java.sql.SQLException;

/**
 * The class implements the Factory pattern. It creates and supplies of JDBC implementations of DAOs
 *
 * @author Slava Makhinich
 */
public final class FactoryDao {

    /**
     * An instance of CompanyDAO
     */
    private static CompanyDAO companyDAO;

    /**
     * An instance of CustomerDAO
     */
    private static CustomerDAO customerDAO;

    /**
     * An instance of DeveloperDAO
     */
    private static DeveloperDAO developerDAO;

    /**
     * An instance of ProjectDAO
     */
    private static ProjectDAO projectDAO;

    /**
     * An instance of SkillDAO
     */
    private static SkillDAO skillDAO;


    /**
     * Private constructor
     */
    private FactoryDao() {
    }

    /**
     * The method returns an instance of CompanyDAO, and invoke method createCompanyDao() if the instance of CompanyDAO
     * is not exist
     *
     * @return an instance of CompanyDAO
     */
    public static CompanyDAO getCompanyDAO() throws SQLException {
        if (companyDAO == null) {
            companyDAO = createCompanyDao();
        }
        return companyDAO;
    }

    /**
     * The method creates and returns an instance of CompanyDAO
     *
     * @return an instance of CompanyDAO
     */
    private static CompanyDAO createCompanyDao() throws SQLException {
        return new JdbcCompanyDAO(ConnectionMySql.getInstance());
    }

    /**
     * The method returns an instance of CustomerDAO, and invoke method createCustomerDao() if the instance of
     * CustomerDAO is not exist
     *
     * @return an instance of CustomerDAO
     */
    public static CustomerDAO getCustomerDAO() throws SQLException {
        if (customerDAO == null) {
            customerDAO = createCustomerDao();
        }
        return customerDAO;
    }

    /**
     * The method creates and returns an instance of CustomerDAO
     *
     * @return an instance of CustomerDAO
     */
    private static CustomerDAO createCustomerDao() throws SQLException {
        return new JdbcCustomerDAO(ConnectionMySql.getInstance().getConnection());
    }

    /**
     * The method returns an instance of DeveloperDAO, and invoke method createDeveloperDao() if the instance of
     * DeveloperDAO is not exist
     *
     * @return an instance of DeveloperDAO
     */
    public static DeveloperDAO getDeveloperDAO() throws SQLException {
        if (developerDAO == null) {
            developerDAO = createDeveloperDao();
        }
        return developerDAO;
    }

    /**
     * The method creates and returns an instance of DeveloperDAO
     *
     * @return an instance of DeveloperDAO
     */
    private static DeveloperDAO createDeveloperDao() throws SQLException {
        return new JdbcDeveloperDao(ConnectionMySql.getInstance());
    }

    /**
     * The method returns an instance of ProjectDAO, and invoke method createProjectDao() if the instance of
     * ProjectDAO is not exist
     *
     * @return an instance of ProjectDAO
     */
    public static ProjectDAO getProjectDAO() throws SQLException {
        if (projectDAO == null) {
            projectDAO = createProjectDao();
        }
        return projectDAO;
    }

    /**
     * The method creates and returns an instance of ProjectDAO
     *
     * @return an instance of ProjectDAO
     */
    private static ProjectDAO createProjectDao() throws SQLException {
        return new JdbcProjectDAO(ConnectionMySql.getInstance().getConnection());
    }

    /**
     * The method returns an instance of SkillDAO, and invoke method createSkillDAO() if the instance of
     * SkillDAO is not exist
     *
     * @return an instance of SkillDAO
     */
    public static SkillDAO getSkillDAO() throws SQLException {
        if (skillDAO == null) {
            skillDAO = createSkillDao();
        }
        return skillDAO;
    }

    /**
     * The method creates and returns an instance of SkillDAO
     *
     * @return an instance of SkillDAO
     */
    private static SkillDAO createSkillDao() throws SQLException {
        return new JdbcSkillDAO(ConnectionMySql.getInstance());
    }
}
