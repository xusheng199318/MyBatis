package com.arthur.daoTemplateTest;

import com.arthur.daoTemplate.JdbcTemplate;
import com.arthur.daoTemplate.OrderDAO;
import com.arthur.daoTemplate.UserDAO;
import com.arthur.daoTemplate.UserDaoTemplate;
import com.arthur.pojo.User;
import org.junit.Test;

public class TestDaoTemplate {

    @Test
    public void testUserDAO() {
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.getUserByUsername("王五"));
    }

    @Test
    public void testOrderDAO() {
        OrderDAO orderDAO = new OrderDAO();
        System.out.println(orderDAO.getOrderByUserId("10"));
    }

    @Test
    public void testJdbcTemplate() {
        JdbcTemplate<User> userDao = new UserDaoTemplate<User>();
        User user = userDao.query("王五");
        System.out.println(user);
    }
}
