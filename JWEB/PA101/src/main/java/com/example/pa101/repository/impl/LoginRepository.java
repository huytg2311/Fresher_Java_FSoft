package com.example.pa101.repository.impl;

import com.example.pa101.repository.ILoginRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class LoginRepository implements ILoginRepository {

    String jdbcUrl = "jdbc:mysql://localhost:3306/db_author";
    String user = "root";
    String pass = "huytg2311";

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    @Override
    public boolean loginAction(String username, String password) {
        boolean status = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl,user,pass);
            String sql = "select * from member where username = ? and password = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            status = resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }
}
