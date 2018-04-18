package com.xiaobin.listener.create;

import com.xiaobin.listener.birthday.Customer;
import com.xiaobin.listener.birthday.DataSourceUtils;
import com.xiaobin.listener.mail.MailUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.mail.MessagingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MyServletContextListener implements ServletContextListener {

    public final static Log log = LogFactory.getLog(MyServletContextListener.class);

    @Override
    //监听context域对象的创建
    public void contextInitialized(ServletContextEvent sce) {
        //就是被监听的对象---ServletContext
        System.out.println("context----create");
        String enCode = sce.getServletContext().getInitParameter("enCode");
        log.error("取出的enCode为：" + enCode);

        //新增调度，发邮件
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat format = new SimpleDateFormat("MM-dd");
                String currentDate = format.format(new Date());

                QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
                String sql = "select * from customer where birthday like ?";
                List<Customer> customers = null;
                try {
                    customers = runner.query(sql, new BeanListHandler<Customer>(Customer.class), "%" + currentDate + "%");
                    log.error("-----customers-----OK!" + customers.size());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (customers != null && customers.size() > 0) {
                    for (Customer customer : customers) {
                        String emailStr = "亲爱的：" + customer.getRealname() + ",生日快乐！";
                        try {
                            MailUtils.sendMail(customer.getEmail(), "Happy Birthday!", emailStr);
                            log.error("-----sendMail-----OK!");
                        } catch (MessagingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Date(), 10 * 1000);

        log.error("-----sendMail-----OK!");
    }

    //监听context域对象的销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context销毁了....");

    }

}
