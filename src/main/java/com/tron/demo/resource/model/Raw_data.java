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
public class Raw_data {

    private List<Contract> contract;
    private String ref_block_bytes;
    private String ref_block_hash;
    private long expiration;
    private long timestamp;
    public void setContract(List<Contract> contract) {
         this.contract = contract;
     }
     public List<Contract> getContract() {
         return contract;
     }

    public void setRef_block_bytes(String ref_block_bytes) {
         this.ref_block_bytes = ref_block_bytes;
     }
     public String getRef_block_bytes() {
         return ref_block_bytes;
     }

    public void setRef_block_hash(String ref_block_hash) {
         this.ref_block_hash = ref_block_hash;
     }
     public String getRef_block_hash() {
         return ref_block_hash;
     }

    public void setExpiration(long expiration) {
         this.expiration = expiration;
     }
     public long getExpiration() {
         return expiration;
     }

    public void setTimestamp(long timestamp) {
         this.timestamp = timestamp;
     }
     public long getTimestamp() {
         return timestamp;
     }

}