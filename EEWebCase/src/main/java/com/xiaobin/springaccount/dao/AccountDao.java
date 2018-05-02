package com.xiaobin.springaccount.dao;

/**
 * @Author: xiaobin3
 * @Description:
 * @Date: Created in 10:39 2018/4/22
 * @Modified by:
 */
public interface AccountDao {
    //加钱
    void increaseMoney(Integer id,Double money);
    //减钱
    void decreaseMoney(Integer id,Double money);
}
