package com.xiaobin.demo;

import com.xiaobin.bean.CollectionBean;
import com.xiaobin.bean.OrdCust;
import com.xiaobin.bean.User;
import org.junit.Test;
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
        user.setName("Amiee");
        User user1 = (User) applicationContext.getBean("User");
        //默认单例模式，applicationContext.xml里面的scope为未配置或者为singleton
        System.out.println(user1);//User{name='tom', age=null}
    }

    @Test
    public void fun5(){

        //1 创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2 向容器"要"user对象
        CollectionBean cb = (CollectionBean) ac.getBean("cb");
        //3 打印user对象
        System.out.println(cb);

    }

    @Test
    public void funContext(){

        //1 创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2 向容器"要"user对象
        OrdCust cb = (OrdCust) ac.getBean("OrdCust");
        //3 打印user对象
        System.out.println(cb);

    }
}
