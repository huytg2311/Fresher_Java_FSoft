package com.example.pa101.repository.impl;

import com.example.pa101.model.Member;
import com.example.pa101.repository.IMemberRepository;

import java.sql.*;

public class MemberRepository implements IMemberRepository {

    String jdbcUrl = "jdbc:mysql://localhost:3306/db_author";
    String user = "root";
    String pass = "huytg2311";

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public void updateMember(Member member) {
        String SQL_UPDATE_MEMBER = "update member " +
                "set firstname = ?," +
                "lastname = ?, " +
                "email = ?, " +
                "phone = ?, " +
                "description = ? where username = ?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, user, pass);
            preparedStatement = connection.prepareStatement(SQL_UPDATE_MEMBER);
            preparedStatement.setString(1, member.getFirstName());
            preparedStatement.setString(2, member.getLastName());
            preparedStatement.setString(3, member.getEmail());
            preparedStatement.setString(4, member.getPhone());
            preparedStatement.setString(5, member.getDescription());
            preparedStatement.setString(6, member.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Member getMemberByUsername(String username) {
        String SQL_GET_BY_ID = "select * from member where username = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, user, pass);
            preparedStatement = connection.prepareStatement(SQL_GET_BY_ID);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Member(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(7),
                        resultSet.getString(6),
                        resultSet.getString(8),
                        resultSet.getString(4)
                        );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addMember(Member member) {
        String SQL_ADD_MEMBER = "insert into member (" +
                "username," +
                "email," +
                "password" +
                ") values (?,?,?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, user, pass);
            preparedStatement = connection.prepareStatement(SQL_ADD_MEMBER);
            preparedStatement.setString(1, member.getUsername());
            preparedStatement.setString(2, member.getEmail());
            preparedStatement.setString(3, member.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
