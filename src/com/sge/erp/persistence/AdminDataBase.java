package com.sge.erp.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminDataBase {

    protected Connection connection;
    protected static final String DRIVER = "org.mariadb.jdbc.Driver";
    protected static final String SERVER = "jdbc:mysql://programmershackers.ddns.net:3306/erp_sge";
    protected static final String USER = "erpsge";
    protected static final String PASSWORD = "erpteam";

    public AdminDataBase() throws ClassNotFoundException {
        Class.forName(DRIVER);

    }

    public void openConnection() throws SQLException {
        connection = DriverManager.getConnection(SERVER, USER, PASSWORD);
    }

    public void closedConnection() throws SQLException {
        connection.close();
    }

}
