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
 * 〈高频查询带宽情况〉
 *
 * @author Monkey
 * @create 2020/12/24 11:26
 */
public class HighFrequencyQuery {

    // 获取带宽详情
    public static void main(String[] args) throws IOException, InterruptedException {
        while(true){
            Thread.sleep(1000);
            String domain = "124.71.141.149";
            Map<Object,Object> map = new HashMap<>();
            map.put("address", "419657bdbe62e20d077b5da1e1917545efd64557cb");
            String result = JsoupUtil.sendPostByBody("http://" + domain + ":16667/wallet/getaccountnet", 3000, GsonUtil.getGson().toJson(map)).getElementsByTag("body").text();
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"  "+result);
        }
    }
}