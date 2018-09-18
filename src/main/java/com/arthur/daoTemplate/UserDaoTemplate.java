package com.arthur.daoTemplate;

import com.arthur.pojo.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDaoTemplate<T> extends JdbcTemplate {

    @Override
    public Object doQuery(Connection connection, String param) {
        T user = null;
        String sql = "SELECT * FROM user WHERE username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, param);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = (T) new com.arthur.pojo.User()
                        .id(resultSet.getInt("id"))
                        .username(resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
