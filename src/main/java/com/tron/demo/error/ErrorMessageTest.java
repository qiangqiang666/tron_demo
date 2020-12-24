package com.tron.demo.error;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;

/**
 * 描述:
 * 〈错误信息解析〉
 *
 * @author Monkey
 * @create 2020/12/24 17:31
 */
public class ErrorMessageTest {

    public static void main(String[] args) throws DecoderException, UnsupportedEncodingException {
        // {"result": {"code": "CONTRACT_VALIDATE_ERROR","message": "56616c6964617465205472616e73666572436f6e7472616374206572726f722c2062616c616e6365206973206e6f742073756666696369656e742e"}}
        String  errorMessage = "56616c6964617465205472616e73666572436f6e7472616374206572726f722c2062616c616e6365206973206e6f742073756666696369656e742e";
        // 第一步: 将字符串信息,转为hex字符数组
        byte[] decodedHex = Hex.decodeHex(errorMessage.toCharArray());
        // 第二步: 将hex字符数组,转为Base64字符数组
        byte[] encodedHexB64 = java.util.Base64.getEncoder().encode(decodedHex);
        // 第三步: Base64解码
        System.out.println(new String(java.util.Base64.getDecoder().decode(encodedHexB64), "UTF-8"));
        //Validate TransferContract error, balance is not sufficient.
    }
}