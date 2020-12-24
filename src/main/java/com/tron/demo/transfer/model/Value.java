/**
  * Copyright 2020 json.cn 
  */
package com.tron.demo.transfer.model;

/**
 * Auto-generated: 2020-12-02 14:59:1
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Value {

    private int amount;
    private String owner_address;
    private String to_address;
    public void setAmount(int amount) {
         this.amount = amount;
     }
     public int getAmount() {
         return amount;
     }

    public void setOwner_address(String owner_address) {
         this.owner_address = owner_address;
     }
     public String getOwner_address() {
         return owner_address;
     }

    public void setTo_address(String to_address) {
         this.to_address = to_address;
     }
     public String getTo_address() {
         return to_address;
     }

}