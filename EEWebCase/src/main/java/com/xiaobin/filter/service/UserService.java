package com.xiaobin.filter.service;

import com.xiaobin.filter.dao.UserDao;
import com.xiaobin.filter.domain.User;

import java.sql.SQLException;


public class UserService {

	public User login(String username, String password) throws SQLException {
		UserDao dao = new UserDao();
		return dao.login(username,password);
	}

}
