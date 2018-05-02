package com.xiaobin.demo;

import com.xiaobin.bean.OrdCust;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器时使用哪个配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
    //将对象注入到u变量中
    @Resource(name = "OrdCust")
    private OrdCust u;

    @Test
    public void fun1() {

        System.out.println(u);

    }

    @Test
    public void fun2() {

        System.out.println(u);

    }

    @Test
    public void fun3() {

        System.out.println(u);

    }
}
