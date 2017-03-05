package com.management.project.dao.jdbc;

import com.management.project.dao.ProjectDAO;
import com.management.project.models.Company;
import com.management.project.models.Customer;
import com.management.project.models.Project;
import com.management.project.utils.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Slava Makhinich
 */
public class JdbcProjectDAO implements ProjectDAO {
    private static final String SAVE = "INSERT INTO project (name, company_id, customer_id) VALUES(?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM project WHERE ID = ?";
    private static final String UPDATE = "UPDATE project SET NAME = ? WHERE ID = ?";
    private static final String DELETE = "DELETE FROM project WHERE ID = ?";
    private static final String FIND_ALL = "SELECT * FROM projects";
    private static final String FIND_BY_NAME = "SELECT * FROM project WHERE NAME = ?";

    private JdbcCompanyDAO jdbcCompanyDAO;
    private JdbcCustomerDAO jdbcCustomerDAO;

    private Connection connection;

    public JdbcProjectDAO(Connection connection) {
        this.connection = connection;
        jdbcCompanyDAO = new JdbcCompanyDAO(connection);
        jdbcCustomerDAO = new JdbcCustomerDAO(connection);
    }


    @Override
    public Project findByName(String name) {
        return null;
    }

    @Override
    public Long save(Project project) {
        return null;
    }

    @Override
    public Project findById(Long aLong) {
        return null;
    }

    @Override
    public void update(Project obj) {

    }

    @Override
    public void delete(Project obj) {

    }

    @Override
    public List<Project> findAll() {
        List<Project> projects = new ArrayList<>();
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            projects = getProjectsListFromResultSet(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println(Constants.ROLLBACK_EXCEPTION_MSG);            }
            System.out.println("SQL exception has occur while trying to find all Projects\n " + e);
        }
        return projects;
    }

    private List<Project> getProjectsListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Project> projects = new ArrayList<>();
        Company company;
        Customer customer;
        long id;
        String name;
        int cost;
        while (resultSet.next()){
            id = resultSet.getLong("id");
            name = resultSet.getString("name");
            cost = resultSet.getInt("cost");
            company = jdbcCompanyDAO.findById(resultSet.getLong("company_id"));
            customer = jdbcCustomerDAO.findById(resultSet.getLong("customer_id"));
            projects.add(new Project(id, name, cost, company, customer));
        }
        return projects;
    }
}
