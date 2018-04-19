package com.xiaobin.dao.impl;

import com.xiaobin.dao.CustomerDao;
import com.xiaobin.domain.Customer;
import com.xiaobin.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void save(Customer c) {
        //1 获得session
        Session session = HibernateUtils.openSession();
        //2 打开事务
        Transaction tx = session.beginTransaction();
        //3 执行保存
        session.save(c);
        //4 提交事务
        tx.commit();
        //5 关闭资源
        session.close();

    }

}
