package com.xiaobin.a_jdbctemplate;

import com.xiaobin.bean.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//使用JDBC模板实现增删改查
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    @Override
    public void save(User u) {
        String sql = "insert into user values(null,?) ";
        super.getJdbcTemplate().update(sql, u.getName());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from user where id = ? ";
        super.getJdbcTemplate().update(sql, id);
    }

    @Override
    public void update(User u) {
        String sql = "update  user set name = ? where id=? ";
        super.getJdbcTemplate().update(sql, u.getName(), u.getId());
    }

    @Override
    public User getById(Integer id) {
        String sql = "select * from user where id = ? ";
        return super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }
        }, id);

    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from user  ";
        Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from user  ";
        List<User> list = super.getJdbcTemplate().query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }
        });
        return list;
    }


}
