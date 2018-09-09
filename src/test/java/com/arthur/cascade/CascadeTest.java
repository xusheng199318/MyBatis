package com.arthur.cascade;

import com.arthur.pojo.Order;
import com.arthur.pojo.UserDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CascadeTest {

    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void destroy() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void testFindUserOrders() {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<UserDTO> userOrderList = orderMapper.getUserOrderList();
        System.out.println(userOrderList);
    }

    @Test
    public void testFindUserByList() {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = orderMapper.getOrderList();
        System.out.println(orderList);
    }
}
