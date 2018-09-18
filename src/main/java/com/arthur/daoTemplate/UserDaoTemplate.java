package com.arthur.daoTemplate;

import com.arthur.pojo.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoTemplate<T> extends JdbcTemplate {

    @Override
    public Object doQuery(Connection connection, String param) {
        T user = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM user WHERE username = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, param);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = (T) new com.arthur.pojo.User()
                        .id(resultSet.getInt("id"))
                        .username(resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, preparedStatement, resultSet);
        }
        return user;
    }

    private void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
