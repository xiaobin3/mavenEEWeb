package com.xiaobin.mybatis.junit;

import com.xiaobin.mybatis.mapper.OrdersMapper;
import com.xiaobin.mybatis.mapper.UserMapper;
import com.xiaobin.mybatis.pojo.Orders;
import com.xiaobin.mybatis.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;


public class JunitTest {

    @Test
    public void testMapper() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = ac.getBean(UserMapper.class);
//		UserMapper mapper = (UserMapper) ac.getBean("userMapper");
        User user = mapper.findUserById(10);
        System.out.println(user);

        OrdersMapper mapper1 = ac.getBean(OrdersMapper.class);
        Orders orders = mapper1.selectByPrimaryKey(5);
        System.out.println(orders);
    }
}
