package com.epam.lab.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlService {
    private String user = "root";
    private String password = "guard3019*";
    private String url = "jdbc:mysql://localhost:3306/university?autoReconnect=true&useSSL=false";

    private Connection connection;

    public MySqlService() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

//        //4. process the result set
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString("emp_name") + " " + resultSet.getString("emp_lname"));
//        }
//        resultSet.close();
//        statement.close();
//        conn.close();

}
