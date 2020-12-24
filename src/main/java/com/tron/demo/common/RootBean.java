package com.tron.demo.common;

import com.tron.demo.common.Transaction;

/**
 * 描述:
 * 〈〉
 *
 * @author Monkey
 * @create 2020/12/2 15:21
 */
public class RootBean {


    private String privateKey;
    private Transaction transaction;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}