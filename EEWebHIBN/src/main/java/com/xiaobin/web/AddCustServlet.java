package com.xiaobin.web;

import com.xiaobin.domain.Customer;
import com.xiaobin.service.CustomerService;
import com.xiaobin.service.impl.CustomerServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: xiaobin3
 * @Description:
 * @Date: Created in 9:30 2018/4/20
 * @Modified by:
 */
public class AddCustServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("AddCustServlet-----------start!");
        Customer customer = new Customer();
        try {
            BeanUtils.populate(customer, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        customerService.save(customer);

        response.sendRedirect(request.getContextPath() + "/listServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
