package com.xiaobin.demo;

import com.xiaobin.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: xiaobin3
 * @Description:
 * @Date: Created in 11:07 2018/4/20
 * @Modified by:
 */
public class Demo1 {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) applicationContext.getBean("User");
        System.out.println(user);
    }
}
