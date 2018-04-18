package com.xiaobin.listener.birthday;

import com.xiaobin.listener.mail.MailUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.mail.MessagingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: xiaobin3
 * @Description:
 * @Date: Created in 10:17 2018/4/18
 * @Modified by:
 */
public class BirthdayListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Web启动---------------");

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("MM-dd");
                String currentTime = format.format(date);
                System.out.println("Web启动---------------"+currentTime);
                //根据当前时间找要过生日的人
                QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
                String sql = "select * from customer where birthday like ?";
                List<Customer> customers = null;
                try {
                    customers = runner.query(sql,new BeanListHandler<Customer>(Customer.class),"%"+currentTime+"%");

                    System.out.println("Web启动---------customers------"+customers.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //发邮件
                if(customers != null && customers.size() > 0){
                    for (Customer c:customers) {
                        System.out.println("Web启动---------customers------"+c.getRealname());
                        String emailMsg = "亲爱的："+c.getRealname()+",生日快乐！";
                        try {
                            MailUtils.sendMail(c.getEmail(),"生日祝福",emailMsg);
                            System.out.println(c.getRealname()+"邮件发送完毕");
                        } catch (MessagingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Date(), 10 * 1000);


        System.out.println("Web---------------");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context销毁了....");
    }
}
