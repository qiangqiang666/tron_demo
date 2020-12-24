package com.tron.demo.common;

import com.google.protobuf.CodedOutputStream;

import java.io.IOException;
import java.util.List;

/**
 * 描述:
 * 〈〉
 *
 * @author Monkey
 * @create 2020/12/2 15:05
 */
public class Transaction {

    private String txID;
    private List<String> signature;
    private String raw_data_hex;
    private String raw_data;
    private boolean visible;

    public String getTxID() {
        return txID;
    }

    public void setTxID(String txID) {
        this.txID = txID;
    }

    public String getRaw_data_hex() {
        return raw_data_hex;
    }

    public void setRaw_data_hex(String raw_data_hex) {
        this.raw_data_hex = raw_data_hex;
    }

    public String getRaw_data() {
        return raw_data;
    }

    public void setRaw_data(String raw_data) {
        this.raw_data = raw_data;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public List<String> getSignature() {
        return signature;
    }

    public void setSignature(List<String> signature) {
        this.signature = signature;
    }
}