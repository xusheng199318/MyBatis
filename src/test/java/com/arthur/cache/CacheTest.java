package com.arthur.cache;

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

/**
 * Created by xusheng on 2018/9/11.
 */
public class CacheTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void testOneLevelCache() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.findUserById(1);
        User user2 = userMapper.findUserById(1);
        System.out.println(user1);
        System.out.println(user2);
    }

    @Test
    public void testTwoLevelCache() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession1.getMapper(UserMapper.class);
        User user1 = userMapper.findUserById(1);
        sqlSession1.close();//当sqlSession1提交时会将数据放入二级缓存

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = userMapper2.findUserById(1);
        System.out.println(user1);
        System.out.println(user2);
    }
}
