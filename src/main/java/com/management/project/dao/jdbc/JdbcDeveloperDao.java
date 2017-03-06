package com.management.project.dao.jdbc;

import com.management.project.dao.DeveloperDAO;
import com.management.project.models.Developer;

import java.sql.Connection;
import java.util.List;

/**
 * Создал пустышку, чтоб не было ошибок компиляции
 */
public class JdbcDeveloperDao implements DeveloperDAO {

    private Connection connection;

    public JdbcDeveloperDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Developer findDeveloperByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Long save(Developer obj) {
        return null;
    }

    @Override
    public Developer findById(Long aLong) {
        return null;
    }

    @Override
    public void update(Developer obj) {

    }

    @Override
    public void delete(Developer obj) {

    }

    @Override
    public List<Developer> findAll() {
        return null;
    }
}
