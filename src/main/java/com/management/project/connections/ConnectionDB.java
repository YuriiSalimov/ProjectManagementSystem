package com.management.project.connections;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Вадим on 28.02.2017.
 */
public interface ConnectionDB {

    Connection getConnection() throws SQLException;
}
