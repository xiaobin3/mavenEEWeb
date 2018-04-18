package com.xiaobin.filter.dao;

import java.sql.SQLException;

import com.xiaobin.filter.domain.User;
import com.xiaobin.listener.birthday.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


public class UserDao {

	public User login(String username, String password) throws SQLException {
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		return runner.query(sql, new BeanHandler<User>(User.class), username,password);
		
	}

}
