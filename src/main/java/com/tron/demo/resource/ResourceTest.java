package com.tron.demo.resource;

import com.tron.demo.resource.model.JsonRootBean2;
import com.tron.demo.common.RootBean;
import com.tron.demo.common.Transaction;
import com.tron.demo.util.GsonUtil;
import com.tron.demo.util.JsoupUtil;

import java.io.IOException;

/**
 * 描述:
 * 〈资源测试类〉
 *
 * @author Monkey
 * @create 2020/12/24 10:56
 */
public class ResourceTest {


    public static void main(String[] args) throws IOException {
        String domain = "124.71.141.149";
        // 交易json
        String str = "{\"visible\":false,\"txID\":\"134f86427c2d1592d81a2c01fc38262b74b1c363e897b49887b169adfd381d01\",\"raw_data\":{\"contract\":[{\"parameter\":{\"value\":{\"frozen_duration\":3,\"frozen_balance\":1000000,\"receiver_address\":\"419657bdbe62e20d077b5da1e1917545efd64557cb\",\"owner_address\":\"4189a5a0304bcd422dbaf74538088201e83fde0e31\"},\"type_url\":\"type.googleapis.com/protocol.FreezeBalanceContract\"},\"type\":\"FreezeBalanceContract\"}],\"ref_block_bytes\":\"0225\",\"ref_block_hash\":\"840f83a1cda33108\",\"expiration\":1608712359000,\"timestamp\":1608712299867},\"raw_data_hex\":\"0a0202252208840f83a1cda3310840d898eaf5e82e5a6e080b126a0a32747970652e676f6f676c65617069732e636f6d2f70726f746f636f6c2e467265657a6542616c616e6365436f6e747261637412340a154189a5a0304bcd422dbaf74538088201e83fde0e3110c0843d18037a15419657bdbe62e20d077b5da1e1917545efd64557cb70dbcae6f5e82e\"}\n";
        JsonRootBean2 jsonRootBean = GsonUtil.getGson().fromJson(str, JsonRootBean2.class);

        Transaction transaction = new Transaction();
        transaction.setTxID(jsonRootBean.getTxID());
        transaction.setVisible(jsonRootBean.getVisible());
        transaction.setRaw_data(GsonUtil.getGson().toJson(jsonRootBean.getRaw_data()));
        transaction.setRaw_data_hex(jsonRootBean.getRaw_data_hex());
        RootBean rootBean = new RootBean();
        rootBean.setPrivateKey("4d6e90d9954dea94504f80877b7f5734753482a2448e562570be3e5b5fdac134");
        rootBean.setTransaction(transaction);
        System.out.println(GsonUtil.getGson().toJson(rootBean));

        // 签名
        String str2 = JsoupUtil.sendPostByBody("http://" + domain + ":16667/wallet/gettransactionsign", 3000, GsonUtil.getGson().toJson(rootBean)).getElementsByTag("body").text();
        JsonRootBean2 jsonBean = GsonUtil.getGson().fromJson(str2, JsonRootBean2.class);
        Transaction transaction1 = new Transaction();
        transaction1.setTxID(jsonBean.getTxID());
        transaction1.setVisible(jsonBean.getVisible());
        transaction1.setRaw_data(GsonUtil.getGson().toJson(jsonBean.getRaw_data()));
        transaction1.setRaw_data_hex(jsonBean.getRaw_data_hex());
        transaction1.setSignature(jsonBean.getSignature());
        System.out.println(GsonUtil.getGson().toJson(transaction1));

        // 广播
        String result = JsoupUtil.sendPostByBody("http://" + domain + ":16667/wallet/broadcasttransaction", 3000, GsonUtil.getGson().toJson(transaction1)).getElementsByTag("body").text();
        System.out.println(result);
    }

}