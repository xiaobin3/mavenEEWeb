package com.xiaobin.mybatis.junit;


import com.xiaobin.mybatis.mapper.OrderMapper;
import com.xiaobin.mybatis.mapper.UserMapper;
import com.xiaobin.mybatis.pojo.Orders;
import com.xiaobin.mybatis.pojo.QueryVo;
import com.xiaobin.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisMapperTest {


    @Test
    public void testMapper() throws Exception {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //SqlSEssion帮我生成一个实现类  （给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


        User user = userMapper.findUserById(10);
        System.out.println(user);
    }
    @Test
    public void testMapperUpdate() throws Exception {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //SqlSEssion帮我生成一个实现类  （给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(16);
//        user.setBirthday(new SimpleDateFormat("yyyy-mm-dd").format(new Date()));
        user.setBirthday(new Date());
        userMapper.updateUserById(user);
        System.out.println(user);
        sqlSession.commit();

        List list = new ArrayList();
        list.add(22);
        list.add(24);
        userMapper.deleteUserByIds(list);
        sqlSession.commit();
    }

    @Test
    public void testMapperQueryVo() throws Exception {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //SqlSEssion帮我生成一个实现类  （给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("五");
        vo.setUser(user);

        List<User> us = userMapper.findUserByQueryVo(vo);
        for (User u : us) {
            System.out.println(u);

        }
    }
    @Test
    public void testMapperQueryVoCOunt() throws Exception {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //SqlSEssion帮我生成一个实现类  （给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Integer i = userMapper.countUser();
        System.out.println(i);
    }
    //	查询订单表order的所有数据
    @Test
    public void testOrderList() throws Exception {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Orders> ordersList = mapper.selectOrdersList();
        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
    }
    //	根据性别和名字查询用户
    @Test
    public void testfindUserBySexAndUsername() throws Exception {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setSex("1");
//		user.setUsername("张小明");
        List<User> users = userMapper.selectUserBySexAndUsername(user);
        for (User user2 : users) {
            System.out.println(user2);
        }
    }
    //多个ID
    @Test
    public void testfindUserIDs() throws Exception {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> ids  = new ArrayList<>();
        ids.add(16);
        ids.add(22);
        ids.add(24);
		/*	QueryVo vo = new QueryVo();
		vo.setIdsList(ids);*/

//		List<User> users = userMapper.selectUserByIds(vo);
/*		Integer[] ids = new Integer[3];
		ids[0] = 16;
		ids[2] = 22;
		ids[1] = 24;*/
        List<User> users = userMapper.selectUserByIds(ids);
        for (User user2 : users) {
            System.out.println(user2);
        }
    }
}
