package com.xiaobin.demo.a_hello;

import com.xiaobin.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;


//测试Hibernate框架
public class Demo {

	@Test
	//保存客户
	public void fun1(){
//		this.configure("/hibernate.cfg.xml");
		Configuration conf = new Configuration().configure();
		
		SessionFactory sessionFactory = conf.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
	
		Transaction tx = session.beginTransaction();
		//----------------------------------------------
		Customer c = new Customer();
		c.setCust_name("google公司");
		
		session.save(c);//执行保存
		
		//----------------------------------------------
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
