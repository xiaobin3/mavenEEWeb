package com.xiaobin.jdbcdemo.jdbcdemo;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


//使用JDBC技术实现查询数据库数据，并显示在控制台中
public class Demo2 {
	@Test
	public void test1() throws Exception  {

		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC", "root", "root");
		//得到执行sql语句的对象Statement
		Statement stmt = conn.createStatement();
		//执行sql语句，并返回结果
		ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");
		//处理结果
		while(rs.next()){
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("-----------------");
		}
		//关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}

	@Test
	public void test2() throws Exception{
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接Connection
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "root");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC", info);
		//得到执行sql语句的对象Statement
		Statement stmt = conn.createStatement();
		//执行sql语句，并返回结果
		ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");
		//处理结果
		while(rs.next()){
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("-----------------");
		}
		//关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}

	@Test
	public void test3() throws Exception{
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC&user=root&password=root");
		//得到执行sql语句的对象Statement
		Statement stmt = conn.createStatement();
		//执行sql语句，并返回结果
		ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");
		//处理结果
		while(rs.next()){
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("-----------------");
		}
		//关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}

	@Test
	public void test4() throws Exception{
		//获取连接Connection
		Connection conn = null;
		//得到执行sql语句的对象Statement
		Statement stmt = null;
		//执行sql语句，并返回结果
		ResultSet rs = null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC?user=root&password=root");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select id,name,password,email,birthday form users");
			//处理结果
			while(rs.next()){
				System.out.println(rs.getObject(1));
				System.out.println(rs.getObject(2));
				System.out.println(rs.getObject(3));
				System.out.println(rs.getObject(4));
				System.out.println(rs.getObject(5));
				System.out.println("-----------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			if(rs!=null){
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				conn = null;
			}

		}
	}
}