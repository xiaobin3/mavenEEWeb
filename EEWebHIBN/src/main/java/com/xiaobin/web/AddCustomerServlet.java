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
 * Servlet implementation class AddCustomerServlet
 */
public class AddCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AddCustomerServlet---------------begin!");
        //1 获得参数并封装到Customer对象
        Customer c = new Customer();
        try {
            BeanUtils.populate(c, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(c);
        //2 调用Service保存客户
        customerService.save(c);
        //3 重定向到客户列表
        response.sendRedirect(request.getContextPath() + "/ListCustomerServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
