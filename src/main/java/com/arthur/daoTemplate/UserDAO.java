package com.arthur.daoTemplate;

import com.arthur.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public User getUserByUsername(String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载驱动
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mybatistest?characterEncoding=utf-8",
                    "root", "123456");//获取连接
            String sql = "SELECT * FROM user WHERE username = ?";//定义sql语句
            preparedStatement = connection.prepareStatement(sql);//预编译sql
            preparedStatement.setString(1, username);//设置参数
            resultSet = preparedStatement.executeQuery();//执行sql并返回结果集
            while (resultSet.next()) {
                user = new User()
                        .id(resultSet.getInt("id"))
                        .username(resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
