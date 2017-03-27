package com.management.project.connections;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * DESCRIPTION - ???
 *
 * @author Вадим
 */
public interface ConnectionDB {

    /**
     *
     * @return
     * @throws SQLException
     */
    Connection getConnection() throws SQLException;
}
