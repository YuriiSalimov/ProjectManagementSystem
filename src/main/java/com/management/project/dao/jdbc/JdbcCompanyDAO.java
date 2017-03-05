package com.management.project.dao.jdbc;

import com.management.project.dao.CompanyDAO;
import com.management.project.models.Company;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Slava on 05.03.2017.
 */
public class JdbcCompanyDAO implements CompanyDAO {
    private Connection connection;

    public JdbcCompanyDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Company findCompanyByName(String companyName) {
        return null;
    }

    @Override
    public Long save(Company obj) {
        return null;
    }

    @Override
    public Company findById(Long aLong) {
        return null;
    }

    @Override
    public void update(Company obj) {

    }

    @Override
    public void delete(Company obj) {

    }

    @Override
    public List<Company> findAll() {
        return null;
    }
}
