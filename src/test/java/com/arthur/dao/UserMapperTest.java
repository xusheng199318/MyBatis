package com.arthur.dao;

import com.arthur.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserMapperTest {

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
    public void testFindUserByList() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(16);
        UserMapper userMapeper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapeper.findUserByList(ids);
        System.out.println(users);
    }

    @Test
    public void testFindUserList() {
        User user = new User();
        UserMapper userMapeper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapeper.findUserList(user));
    }

    @Test
    public void  testFindUserByUser() {
        User user = new User().id(1);
        UserMapper userMapeper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapeper.findUserByUser(user));
    }

    @Test
    public void testGetCountUsers() {
        UserMapper userMapeper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapeper.getCountUsers());
    }

    @Test
    public void testFindUserByIdAndUsername() {
        User user1 = new User().id(16);
        User user2 = new User().username("张小明");
        UserMapper userMapeper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapeper.findUserByIdAndUsername(user1, user2);
        System.out.println(users);
    }

    @Test
    public void testUserMapper() {
        UserMapper userMapeper = sqlSession.getMapper(UserMapper.class);
        User user = userMapeper.findUserById(1);
        System.out.println(user);
    }


}
