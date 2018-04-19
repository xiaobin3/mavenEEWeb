package com.xiaobin.service.impl;

import com.xiaobin.dao.CustomerDao;
import com.xiaobin.dao.impl.CustomerDaoImpl;
import com.xiaobin.domain.Customer;
import com.xiaobin.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public void save(Customer c) {
        //调用Dao保存客户
        customerDao.save(c);
    }

}
