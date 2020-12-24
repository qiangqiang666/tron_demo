/**
  * Copyright 2020 json.cn 
  */
package com.tron.demo.resource.model;

import java.util.List;

/**
 * Auto-generated: 2020-12-23 11:57:41
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class JsonRootBean {

    private boolean visible;
    private List<String> signature;
    private String txID;
    private Raw_data raw_data;
    private String raw_data_hex;
    public void setVisible(boolean visible) {
         this.visible = visible;
     }
     public boolean getVisible() {
         return visible;
     }

    public void setTxID(String txID) {
         this.txID = txID;
     }
     public String getTxID() {
         return txID;
     }

    public void setRaw_data(Raw_data raw_data) {
         this.raw_data = raw_data;
     }
     public Raw_data getRaw_data() {
         return raw_data;
     }

    public void setRaw_data_hex(String raw_data_hex) {
         this.raw_data_hex = raw_data_hex;
     }
     public String getRaw_data_hex() {
         return raw_data_hex;
     }

    public boolean isVisible() {
        return visible;
    }

    public List<String> getSignature() {
        return signature;
    }

    public void setSignature(List<String> signature) {
        this.signature = signature;
    }
}