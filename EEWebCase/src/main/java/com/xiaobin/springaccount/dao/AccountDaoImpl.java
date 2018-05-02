package com.xiaobin.springaccount.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @Author: xiaobin3
 * @Description:
 * @Date: Created in 10:39 2018/4/22
 * @Modified by:
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void increaseMoney(Integer id, Double money) {

        getJdbcTemplate().update("UPDATE account SET money = money + ? WHERE id = ? ", money, id);
    }

    @Override
    public void decreaseMoney(Integer id, Double money) {

        getJdbcTemplate().update("UPDATE account SET money = money - ? WHERE id = ? ", money, id);
    }
}
