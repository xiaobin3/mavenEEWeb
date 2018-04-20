package com.xiaobin.jdbcdemo.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//使用JDBC技术实现查询数据库数据，并显示在控制台中
public class Demo1 {

	public static void main(String[] args) throws Exception {


		//注册驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());

		//获取连接Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/maven_spring_data?serverTimezone=UTC", "develop", "develop");
		//得到执行sequel语句的对象Statement
		Statement stmt = conn.createStatement();
		//执行sql语句，并返回结果
		ResultSet rs = stmt.executeQuery("select password,email,birthday,name from user");

		//处理结果
		while(rs.next()){
			System.out.println(rs.getObject("password"));
			System.out.println(rs.getObject("name"));
			System.out.println(rs.getObject("birthday"));
			System.out.println(rs.getObject("email"));
			System.out.println("-----------------");
		}

		//关闭资源
		rs.close();
		stmt.close();
		conn.close();


	}

}
