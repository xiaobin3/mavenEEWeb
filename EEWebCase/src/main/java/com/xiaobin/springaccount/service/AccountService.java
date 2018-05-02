package com.xiaobin.springaccount.service;

/**
 * @Author: xiaobin3
 * @Description:
 * @Date: Created in 10:45 2018/4/22
 * @Modified by:
 */
public interface AccountService {
    //转账方法
    void transfer(Integer from, Integer to, Double money);
}
