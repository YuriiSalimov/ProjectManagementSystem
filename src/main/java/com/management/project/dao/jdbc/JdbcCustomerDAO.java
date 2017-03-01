package dao.jdbc;

import dao.CustomerDAO;
import model.Customer;
import utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Perevoznyk Pavel on 24.02.2017.
 */
public class JdbcCustomerDAO implements CustomerDAO {

    private final String MAKE_PERSISTENT = "INSERT INTO customers (NAME) VALUES(?)";
    private final String FIND_BY_ID = "SELECT * FROM customers WHERE ID = ?";
    private final String UPDATE = "UPDATE customers SET NAME = ? WHERE ID = ?";
    private final String MAKE_TRANSIENT = "DELETE FROM customers WHERE ID = ?";
    private final String FIND_ALL = "SELECT * FROM customers";
    private final String FIND_BY_NAME = "SELECT * FROM customers WHERE NAME = ?";

    private Connection connection;

    public JdbcCustomerDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long save(Customer obj) {
        Long id = null;
        try (PreparedStatement preparedStatement1 = connection.prepareStatement(MAKE_PERSISTENT);
             PreparedStatement preparedStatement2 = connection.prepareStatement(Constants.GET_LAST_ID)) {
            preparedStatement1.setString(1, obj.getName());
            preparedStatement1.execute();
            connection.commit();
            ResultSet rs = preparedStatement2.executeQuery();
            rs.next();
            id = rs.getLong(1);
            rs.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println(Constants.ROLLBACK_EXCEPTION_MSG);
            }
            System.out.println("SQL exception has occur while trying to make persistent Customer: " + obj.getName() + "\n" + e);
        }
        return id;
    }

    @Override
    public Customer findById(Long id) {
        Customer customer = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            customer = buildCustomersFromResultSet(resultSet).get(0);
            resultSet.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println(Constants.ROLLBACK_EXCEPTION_MSG);
            }
            System.out.println("SQL exception has occur while trying to find Customer with ID: " + id + "\n " + e);
        }
        return customer;
    }

    @Override
    public void update(Customer obj) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setLong(2, obj.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println(Constants.ROLLBACK_EXCEPTION_MSG);
            }
            System.out.println("SQL exception has occur while trying to update Customer with ID: " + obj.getId() + "\n" + e);
        }
    }

    @Override
    public void delete(Customer obj) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(MAKE_TRANSIENT)) {
            preparedStatement.setLong(1, obj.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println(Constants.ROLLBACK_EXCEPTION_MSG);
            }
            System.out.println("SQL exception has occur while trying to make transient Customer with ID: " + obj.getId());
        }
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            customers = buildCustomersFromResultSet(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println(Constants.ROLLBACK_EXCEPTION_MSG);
            }
            System.out.println("SQL exception has occur while trying to find all Customers\n " + e);
        }
        return customers;
    }

    @Override
    public Customer findCustomerByName(String name) {
        Customer customer = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            customer = buildCustomersFromResultSet(resultSet).get(0);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println(Constants.ROLLBACK_EXCEPTION_MSG);
            }
            System.out.println("SQL exception has occur while trying to retrieve Customer with Name: " + name);
        }
        return customer;
    }

    private List<Customer> buildCustomersFromResultSet(ResultSet rs) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        Customer customer = null;
        while (rs.next()) {
            customer = new Customer(rs.getLong("id"), rs.getString("name"));
            customers.add(customer);
        }
        return customers;
    }
}
