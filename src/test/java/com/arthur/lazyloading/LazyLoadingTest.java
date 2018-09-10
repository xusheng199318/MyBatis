package com.arthur.lazyloading;

import com.arthur.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class LazyLoadingTest {

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
    public void testNoLazyLoading() {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order ordersAndUser = orderMapper.findOrdersAndUser(3);
    }

    @Test
    public void testAggressiveLazyLoading() {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order ordersAndUser = orderMapper.findOrdersAndUser(3);
        System.out.println(ordersAndUser);
    }

    @Test
    public void testDeepLazyLoading() {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order ordersAndUser = orderMapper.findOrdersAndUser(3);
        System.out.println(ordersAndUser);
    }

}

