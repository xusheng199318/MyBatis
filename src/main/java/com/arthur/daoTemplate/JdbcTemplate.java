package com.arthur.daoTemplate;



import java.sql.*;

public abstract class JdbcTemplate<T> {

    private Connection createConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mybatistest?characterEncoding=utf-8",
                    "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
       return connection;
    }

    public T query(String param) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = createConnection();
        T t = doQuery(connection, param);
        closeResource(connection, preparedStatement, resultSet);
        return t;
    }

    private void closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract T doQuery(Connection connection, String param);




}
