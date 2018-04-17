package com.xiaobin.sheet.web;

import com.xiaobin.sheet.domain.Product;
import com.xiaobin.sheet.service.ProductService;
import com.xiaobin.sheet.vo.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class ProductListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductService service = new ProductService();

        //模拟当前是第一页
        String currentPageStr = request.getParameter("currentPage");
        if (currentPageStr == null) currentPageStr = "1";
        int currentPage = Integer.parseInt(currentPageStr);
        //认为每页显示12条
        int currentCount = 12;

        PageBean<Product> pageBean = null;
        try {
            pageBean = service.findPageBean(currentPage, currentCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("pageBean", pageBean);

        request.getRequestDispatcher("/product_list.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}