package com.arthur.daoTemplate;

import com.arthur.pojo.Order;
import com.arthur.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDAO {

    public Order getOrderByUserId(String userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Order order = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载驱动
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mybatistest?characterEncoding=utf-8",
                    "root", "123456");//获取连接
            String sql = "SELECT * FROM orders where user_id = ?";//定义sql语句
            preparedStatement = connection.prepareStatement(sql);//预编译sql
            preparedStatement.setInt(1, Integer.parseInt(userId));//设置参数
            resultSet = preparedStatement.executeQuery();//执行sql并返回结果集
            while (resultSet.next()) {
                order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setNumber(resultSet.getString("number"));
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
        return order;
    }
}
