package com.xiaobin.springaccount.tx;

import com.xiaobin.springaccount.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author: xiaobin3
 * @Description:
 * @Date: Created in 10:54 2018/4/22
 * @Modified by:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
    @Resource(name = "accountService")
    AccountService accountService;

    @Test
    public void testTransfer(){
        accountService.transfer(1,2,1000d);
    }
}
