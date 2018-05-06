package com.xiaobin.mybatis.mapper;

import com.xiaobin.mybatis.pojo.Orders;
import com.xiaobin.mybatis.pojo.User;

import java.util.List;


public interface OrderMapper {
	
	
//	查询订单表order的所有数据

	public List<Orders> selectOrdersList();
	
	//一对一关联 查询  以订单为中心 关联用户
	public List<Orders> selectOrders();
	
	//一对多关联
	public List<User> selectUserList();
	
}
