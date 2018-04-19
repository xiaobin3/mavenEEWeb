package com.xiaobin.dao;

import com.xiaobin.domain.User;
import com.xiaobin.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;


public class UserDao {

    public User login(String userName,String password) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username = ? and password = ?";
        User user = runner.query(sql,new BeanHandler<User>(User.class),userName,password);
        return user;
    }

    public int regist(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        int update = runner.update(sql, user.getUid(), user.getUsername(), user.getPassword(),
                user.getName(), user.getEmail(), user.getTelephone(), user.getBirthday(),
                user.getSex(), user.getState(), user.getCode());
        return update;
    }

    //激活
    public void active(String activeCode) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set state=? where code=?";
        runner.update(sql, 1, activeCode);
    }

    //校验用户名是否存在
    public Long checkUsername(String username) throws SQLException {
        System.out.println("校验用户名"+username+"是否存在");
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from user where username=?";
        Long query = (Long) runner.query(sql, new ScalarHandler(), username);
        System.out.println("校验用户名是否存在"+query);
        return query;
    }

    public static void main(String[] args){
        UserDao userDao = new UserDao();
        try {
            Long count = userDao.checkUsername("lili");
            System.out.println("校验用户名是否存在:"+count);
//            QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
//            String sql = "select count(*) from user where username=?";
//            User user = runner.query(sql, new BeanHandler<User>(User.class), "aaa");
//            System.out.println("User:"+user.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("FAILED!"+e.getMessage());
        }
    }

    @Test
    public void activeTest() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set state=? where code=?";
        runner.update(sql, 1, "91e64a78-54d4-4cf4-b0ff-6d22d0f55072");
    }

}


