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
public class Raw_data {

    private Long number;
    private String txTrieRoot;
    private String witness_address;
    private String parentHash;
    private int version;
    private long timestamp;
    public void setNumber(Long number) {
         this.number = number;
     }
     public Long getNumber() {
         return number;
     }

    public void setTxTrieRoot(String txTrieRoot) {
         this.txTrieRoot = txTrieRoot;
     }
     public String getTxTrieRoot() {
         return txTrieRoot;
     }

    public void setWitness_address(String witness_address) {
         this.witness_address = witness_address;
     }
     public String getWitness_address() {
         return witness_address;
     }

    public void setParentHash(String parentHash) {
         this.parentHash = parentHash;
     }
     public String getParentHash() {
         return parentHash;
     }

    public void setVersion(int version) {
         this.version = version;
     }
     public int getVersion() {
         return version;
     }

    public void setTimestamp(long timestamp) {
         this.timestamp = timestamp;
     }
     public long getTimestamp() {
         return timestamp;
     }

}