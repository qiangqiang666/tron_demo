package com.tron.demo.resource;

import com.tron.demo.util.GsonUtil;
import com.tron.demo.util.JsoupUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 〈高频转账类〉
 *
 * @author Monkey
 * @create 2020/12/24 11:24
 */
public class HighFrequencyTransfer {

    // 快捷转账
    public static void main(String[] args) throws IOException, InterruptedException {
        while (true){
            Thread.sleep(100);
            String domain = "124.71.141.149";
            Map<Object,Object> map = new HashMap<>();
            map.put("privateKey", "1714e37c1b241e7b8739d76f4e037612528b97fad19a99086b830ff6f4a01ddb");
            map.put("toAddress","4189a5a0304bcd422dbaf74538088201e83fde0e31" );
            map.put("amount",10000 );
            String result = JsoupUtil.sendPostByBody("http://" + domain + ":16667/wallet/easytransferbyprivate", 3000, GsonUtil.getGson().toJson(map)).getElementsByTag("body").text();
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"  "+result);
        }
    }
}