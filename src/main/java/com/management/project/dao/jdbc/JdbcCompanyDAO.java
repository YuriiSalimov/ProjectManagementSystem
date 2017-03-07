package com.management.project.dao.jdbc;

import com.management.project.connections.ConnectionDB;
import com.management.project.dao.CompanyDAO;
import com.management.project.models.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slava on 05.03.2017.
 */
public class JdbcCompanyDAO implements CompanyDAO {

    private final static String SAVE = "INSERT INTO companies (name) VALUES(?)";
    private final static String LAST_INSERTED_ID = "INSERT INTO companies (name) VALUES(?)";
    private final static String FIND_BY_ID = "SELECT * FROM companies WHERE id = ?";
    private final static String UPDATE = "UPDATE companies SET name = ? WHERE id = ?";
    private final static String DELETE = "DELETE FROM companies WHERE id = ?";
    private final static String FIND_ALL = "SELECT * FROM companies";
    private final static String FIND_BY_NAME = "SELECT * FROM companies WHERE name = ? ";

    private ConnectionDB connectionDB;

    public JdbcCompanyDAO(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public Company findByName(String companyName) {
        try (Connection connection = connectionDB.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME)) {
                preparedStatement.setString(1, companyName);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    Company foundedCompany=new Company(resultSet.getLong("id"), resultSet.getString("name"));
                    return foundedCompany;
                }else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long save(Company obj) {
        Long id;
        try (Connection connection = connectionDB.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
                preparedStatement.setString(1, obj.getName());
                preparedStatement.executeUpdate();
            }
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(LAST_INSERTED_ID);
                resultSet.next();
                id = resultSet.getLong(1);
            }
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Company findById(Long aLong) {
        Company foundedCompany;
        foundedCompany= null;
        try (Connection connection = connectionDB.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
                preparedStatement.setLong(1,aLong);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    foundedCompany = new Company(
                            resultSet.getLong("id"), resultSet.getString("name"));
//                    foundedCompany.setName(resultSet.getString("name"));
//                    foundedCompany.setId(resultSet.getLong("id"));
                }
            }
            return foundedCompany;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Company obj) {
        try (Connection connection = connectionDB.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
                preparedStatement.setString(1,obj.getName());
                preparedStatement.setLong(2,obj.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Company obj) {
        try (Connection connection = connectionDB.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
                preparedStatement.setLong(1,obj.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Company> findAll() {
        List<Company> allCompanies = new ArrayList<>();
        try (Connection connection = connectionDB.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    allCompanies.add(new Company(resultSet.getLong("id"), resultSet.getString("name")));
                }
            }
            return allCompanies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
