package com.arthur.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * Created by xusheng on 2018/9/4.
 * 通过JDBC的方式连接数据库
 */
public class JDBCTest {

    @Test
    public void testSelect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");//加载驱动
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mybatistest?characterEncoding=utf-8",
                    "root", "123456");//获取连接
            String sql = "SELECT * FROM user WHERE username = ?";//定义sql语句
            preparedStatement = connection.prepareStatement(sql);//预编译sql
            preparedStatement.setString(1, "王五");//设置参数
            resultSet = preparedStatement.executeQuery();//执行sql并返回结果集
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("id")
                        + " "
                        + resultSet.getString("username"));
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
    }
}
