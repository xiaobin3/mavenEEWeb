package com.xiaobin.core.dao;

import com.xiaobin.core.bean.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> selectCustomerList(Customer customer);

    Integer selectCustomerListCount(Customer customer);

    Customer getCustomerById(Long id);

    void updateCustomer(Customer customer);

    void deleteCustomer(Long id);

}