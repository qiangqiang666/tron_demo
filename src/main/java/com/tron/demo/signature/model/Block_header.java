/**
  * Copyright 2020 json.cn 
  */
package com.tron.demo.signature.model;

/**
 * Auto-generated: 2020-12-24 13:30:35
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Block_header {

    private Raw_data raw_data;
    private String witness_signature;
    public void setRaw_data(Raw_data raw_data) {
         this.raw_data = raw_data;
     }
     public Raw_data getRaw_data() {
         return raw_data;
     }

    public void setWitness_signature(String witness_signature) {
         this.witness_signature = witness_signature;
     }
     public String getWitness_signature() {
         return witness_signature;
     }

}