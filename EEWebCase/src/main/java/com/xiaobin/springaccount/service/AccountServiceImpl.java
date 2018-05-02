package com.xiaobin.springaccount.service;

import com.xiaobin.springaccount.dao.AccountDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Author: xiaobin3
 * @Description:
 * @Date: Created in 10:46 2018/4/22
 * @Modified by:
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    private TransactionTemplate transactionTemplate;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

//    public void transfer(final Integer from, final Integer to, final Double money) {
//        //减钱
//        accountDao.decreaseMoney(from, money);
////        int i = 1 / 0;
//        //加钱
//        accountDao.increaseMoney(to, money);
//    }


    public void transfer(final Integer from, final Integer to, final Double money) {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                //减钱
                accountDao.decreaseMoney(from, money);
//                int i = 1 / 0;
                //加钱
                accountDao.increaseMoney(to, money);
            }
        });
    }

}
