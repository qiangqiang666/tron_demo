package com.tron.demo.createaccount;

import com.tron.demo.common.RootBean;
import com.tron.demo.common.Transaction;
import com.tron.demo.util.GsonUtil;
import com.tron.demo.util.JsoupUtil;

import java.io.IOException;

/**
 * 描述:
 * 〈创建/激活账户〉
 *
 * @author Monkey
 * @create 2020/12/24 13:53
 */
public class AccountTest {


    public static void main(String[] args) throws IOException {
        String domain = "124.71.xx.xx";
        // 交易json
        String str = "{\"visible\":false,\"txID\":\"d3a2348f41756b3250eb279777fef62c7ac887401d1144507bbc8ef9303c4de8\",\"raw_data\":{\"contract\":[{\"parameter\":{\"value\":{\"owner_address\":\"417073a1d13330fc81598d271e65023fb7d8d69e25\",\"account_address\":\"4172003e4839e9cd68bcd036811fd8797133f9c862\"},\"type_url\":\"type.googleapis.com/protocol.AccountCreateContract\"},\"type\":\"AccountCreateContract\"}],\"ref_block_bytes\":\"58a2\",\"ref_block_hash\":\"d081d330cc078861\",\"expiration\":1608789582000,\"timestamp\":1608789524486},\"raw_data_hex\":\"0a0258a22208d081d330cc07886140b0c1d39ae92e5a6612640a32747970652e676f6f676c65617069732e636f6d2f70726f746f636f6c2e4163636f756e74437265617465436f6e7472616374122e0a15417073a1d13330fc81598d271e65023fb7d8d69e2512154172003e4839e9cd68bcd036811fd8797133f9c862708680d09ae92e\"}\n";
        com.tron.demo.createaccount.model.JsonRootBean jsonRootBean = GsonUtil.getGson().fromJson(str, com.tron.demo.createaccount.model.JsonRootBean.class);

        Transaction transaction = new Transaction();
        transaction.setTxID(jsonRootBean.getTxID());
        transaction.setVisible(jsonRootBean.getVisible());
        transaction.setRaw_data(GsonUtil.getGson().toJson(jsonRootBean.getRaw_data()));
        transaction.setRaw_data_hex(jsonRootBean.getRaw_data_hex());
        RootBean rootBean = new RootBean();
        rootBean.setPrivateKey("c877ec3ef3b1eed56556042b4af9f1a8b108c2ac8c183727d9d01fdb9fecc727");
        rootBean.setTransaction(transaction);
        System.out.println(GsonUtil.getGson().toJson(rootBean));

        // 签名
        String str2 = JsoupUtil.sendPostByBody("http://" + domain + ":16667/wallet/gettransactionsign", 3000, GsonUtil.getGson().toJson(rootBean)).getElementsByTag("body").text();
        com.tron.demo.createaccount.model.JsonRootBean jsonBean = GsonUtil.getGson().fromJson(str2, com.tron.demo.createaccount.model.JsonRootBean.class);
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