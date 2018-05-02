package com.xiaobin.springaopannonation;

import com.xiaobin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextAOPAnno.xml")
public class Demo {
    @Resource(name = "userService")
    private UserService us;

    @Test
    public void fun1() {
//        这是环绕通知之前的部分!!
//        这是前置通知!!
//        保存用户!
//        这是环绕通知之后的部分!!
//        这是后置通知(出现异常也会调用)!!
//        这是后置通知(如果出现异常不会调用)!!
        us.save();
    }

}
