package com.example.pa101.repository.impl;

import com.example.pa101.model.Content;
import com.example.pa101.repository.IContentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContentRepository implements IContentRepository {

    String jdbcUrl = "jdbc:mysql://localhost:3306/db_author";
    String user = "root";
    String pass = "huytg2311";

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public List<Content> getAllContent() {
        List<Content> contentList = new ArrayList<>();
        String SQL_SELECT_ALL = "select id, title, brief, create_date from content";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, user, pass);
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                contentList.add(new Content(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getTimestamp(4)
                ));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contentList;

    }

    @Override
    public void addContext(Content content) {
        String SQL_CREATE_CONTENT = "insert into content (" +
                "title, brief, content, create_date) " +
                "values (?,?,?,?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, user, pass);
            preparedStatement = connection.prepareStatement(SQL_CREATE_CONTENT);
            preparedStatement.setString(1, content.getTitle());
            preparedStatement.setString(2, content.getBrief());
            preparedStatement.setString(3, content.getContent());
            preparedStatement.setTimestamp(4, content.getCreate_date());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Content getByTitle(String title) {
        String SQL_GET_BY_ID = "SELECT * FROM content WHERE title = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, user, pass);
            preparedStatement = connection.prepareStatement(SQL_GET_BY_ID);
            preparedStatement.setString(1, title);
            preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
