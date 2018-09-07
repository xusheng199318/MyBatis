package com.arthur.mybatis;

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
import java.util.Date;
import java.util.List;

/**
 * Created by xusheng on 2018/9/4.
 * MyBatis基本应用
 * MyBatis最原始的使用方式，
 * 通过SqlSessionFactoryBuilder构建SqlSessionFactory
 * 从SqlSessionFactory中获取一个SqlSession
 *
 */
public class MyBatisTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void testSelectOne() {
        User user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(user);
    }

    @Test
    public void testSelectList() {
        List<User> users  = sqlSession.selectList("findByUserName", "张");
        System.out.println(users);
    }

    @Test
    public void testInsert() {
        User user = new User()
                .username("test03")
                .sex("男")
                .birthday(new Date())
                .address("上海");

        System.out.println(user);
        sqlSession.insert("test.insertUser", user);
        System.out.println(user);
        sqlSession.commit();
        System.out.println(user);
    }

    @Test
    public void testDelete() {
        sqlSession.delete("test.deleteUserById", 39);
        sqlSession.commit();
    }

    @Test
    public void testUpdate() {
        User user = new User().id(38).username("test03");
        sqlSession.update("test.updateUserById", user);
        sqlSession.commit();
    }

    @After
    public void destroy() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
