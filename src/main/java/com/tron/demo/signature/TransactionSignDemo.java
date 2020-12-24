package com.tron.demo.signature;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.tron.demo.address.AddressConverTest;
import com.tron.demo.address.util.Sha256Hash;
import com.tron.demo.util.GsonUtil;
import com.tron.demo.util.JsoupUtil;
import org.bouncycastle.util.encoders.Hex;
import org.tron.common.crypto.ECKey;
import org.tron.common.utils.ByteArray;
import org.tron.core.exception.CancelException;
import org.tron.protos.Protocol.Transaction;
import org.tron.protos.contract.BalanceContract;

public class TransactionSignDemo {


    public static void main(String[] args) throws IOException, CancelException {
        String domain = "124.71.xx.xx";
        String privateStr = "c877ec3ef3b1eed56556042b4af9f1a8b108c2ac8c183727d9d01fdb9fecc727";
        byte[] privateBytes = ByteArray.fromHexString(privateStr);
        ECKey ecKey = ECKey.fromPrivate(privateBytes);
        byte[] from = ecKey.getAddress();
        byte[] to = AddressConverTest.decode58Check("CLMzKqCAyokt9gjjrQh7ozD31954uPGvnU");
        // 100 COC, api only receive coc in Bai, and 1 coc = 1000000 Bai,amount = 100_000_000L;
        long amount = 1000L;

        // 查询链上最新区块数据
        String blockStr = JsoupUtil.sendGet("http://" + domain + ":16667/wallet/getnowblock", 3000).getElementsByTag("body").text();
        com.tron.demo.signature.model.JsonRootBean blockInfo=GsonUtil.getGson().fromJson(blockStr, com.tron.demo.signature.model.JsonRootBean.class);
        Long blockTimestamp = blockInfo.getBlock_header().getRaw_data().getTimestamp();
        Long blockHeight = blockInfo.getBlock_header().getRaw_data().getNumber();
        byte[] blockHash = Hex.decode(blockInfo.getBlockID());

        // 创建交易
        Transaction transaction1 = createTransaction(from, to, amount, blockTimestamp, blockHeight, blockHash);
        byte[] transactionBytes = transaction1.toByteArray();
        // 交易签名
        byte[] transaction4 = signTransaction2Byte(transactionBytes, privateBytes);

        // 广播交易
        Map<String,String> sendMap=new HashMap<>(1);
        sendMap.put("transaction", ByteArray.toHexString(transaction4));
        String result = JsoupUtil.sendPostByBody("http://" + domain + ":16667/wallet/broadcasthex", 3000,GsonUtil.getGson().toJson(sendMap)).getElementsByTag("body").text();
        System.out.println(result);
    }



    public static Transaction createTransaction(byte[] from, byte[] to, long amount,long blockTimestamp,long blockHeight,byte[] blockHash) {
        Transaction.Builder transactionBuilder = Transaction.newBuilder();

        Transaction.Contract.Builder contractBuilder = Transaction.Contract.newBuilder();
        BalanceContract.TransferContract.Builder transferContractBuilder = BalanceContract.TransferContract.newBuilder();
        transferContractBuilder.setAmount(amount);
        ByteString bsTo = ByteString.copyFrom(to);
        ByteString bsOwner = ByteString.copyFrom(from);
        transferContractBuilder.setToAddress(bsTo);
        transferContractBuilder.setOwnerAddress(bsOwner);
        try {
            Any any = Any.pack(transferContractBuilder.build());
            contractBuilder.setParameter(any);
        } catch (Exception e) {
            return null;
        }
        contractBuilder.setType(Transaction.Contract.ContractType.TransferContract);
        transactionBuilder.getRawDataBuilder().addContract(contractBuilder).setTimestamp(System.currentTimeMillis())
                .setExpiration(blockTimestamp + 10 * 60 * 60 * 1000);
        Transaction transaction = transactionBuilder.build();
        Transaction refTransaction = setReference(transaction, blockHeight,blockHash);
        return refTransaction;
    }
    public static Transaction setReference(Transaction transaction, long blockHeight,byte[] blockHash) {
        byte[] refBlockNum = ByteArray.fromLong(blockHeight);
        Transaction.raw rawData = transaction.getRawData().toBuilder()
                .setRefBlockHash(ByteString.copyFrom(ByteArray.subArray(blockHash, 8, 16)))
                .setRefBlockBytes(ByteString.copyFrom(ByteArray.subArray(refBlockNum, 6, 8))).build();
        return transaction.toBuilder().setRawData(rawData).build();
    }


	private static byte[] signTransaction2Byte(byte[] transaction, byte[] privateKey)
			throws InvalidProtocolBufferException {
		ECKey ecKey = ECKey.fromPrivate(privateKey);
		Transaction transaction1 = Transaction.parseFrom(transaction);
		byte[] rawdata = transaction1.getRawData().toByteArray();
		byte[] hash = Sha256Hash.hash(true,rawdata);
		byte[] sign = ecKey.sign(hash).toByteArray();
		return transaction1.toBuilder().addSignature(ByteString.copyFrom(sign)).build().toByteArray();
	}



}