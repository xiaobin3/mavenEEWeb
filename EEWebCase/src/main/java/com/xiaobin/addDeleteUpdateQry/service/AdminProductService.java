package com.xiaobin.addDeleteUpdateQry.service;

import com.xiaobin.addDeleteUpdateQry.dao.AdminProductDao;
import com.xiaobin.addDeleteUpdateQry.domain.Category;
import com.xiaobin.addDeleteUpdateQry.domain.Product;
import com.xiaobin.addDeleteUpdateQry.domain.User;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;


public class AdminProductService {
	
	//查询所有的商品
	public List<Product> findAllProduct() throws SQLException {
		//因为没有复杂业务 直接传递请求到dao层
		AdminProductDao dao = new AdminProductDao();
		return dao.findAllProduct();
	}

	//获得所有的类别
	public List<Category> findAllCategory() throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		return dao.findAllCategory();
	}

	//添加数据
	public void addProduct(Product product) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.addProduct(product);
	}

	//根据pid删除商品
	public void delProductByPid(String pid) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.delProductByPid(pid);
	}

	
	//根据pid查询商品对象
	public Product findProductByPid(String pid) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		return dao.findProductByPid(pid);
	}

	
	//更新商品
	public void updateProduct(Product product) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.updateProduct(product);
	}

	public void insertUser(User user) throws SQLException {
		AdminProductDao dao = new AdminProductDao();
		dao.insertUser(user);
	}

	public static void main(String[] args) throws SQLException {
//		username, password, name, email, telephone, birthday, sex, state
		User user = new User();
		user.setUid(UUID.randomUUID().toString());
		user.setUserName("maven");
		user.setPassWord("!@#$%^&*(");
		user.setEmail("jsdh@123.com");
		user.setName("键盘");
		user.setTelephone("19191919191");
		user.setBirthday("1999-09-09");
		user.setSex("male");
		user.setState(1);
		AdminProductService adminProductService = new AdminProductService();
		adminProductService.insertUser(user);
		System.out.println("--------------------------OK!");
	}

}
