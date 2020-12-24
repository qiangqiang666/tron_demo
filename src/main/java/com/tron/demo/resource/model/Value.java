/**
  * Copyright 2020 json.cn 
  */
package com.tron.demo.resource.model;

/**
 * Auto-generated: 2020-12-23 11:57:41
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Value {

    private String resource;
    private int frozen_duration;
    private long frozen_balance;
    private String receiver_address;
    private String owner_address;
    public void setResource(String resource) {
         this.resource = resource;
     }
     public String getResource() {
         return resource;
     }

    public void setFrozen_duration(int frozen_duration) {
         this.frozen_duration = frozen_duration;
     }
     public int getFrozen_duration() {
         return frozen_duration;
     }

    public void setFrozen_balance(long frozen_balance) {
         this.frozen_balance = frozen_balance;
     }
     public long getFrozen_balance() {
         return frozen_balance;
     }

    public void setReceiver_address(String receiver_address) {
         this.receiver_address = receiver_address;
     }
     public String getReceiver_address() {
         return receiver_address;
     }

    public void setOwner_address(String owner_address) {
         this.owner_address = owner_address;
     }
     public String getOwner_address() {
         return owner_address;
     }

}