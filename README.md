# tron_demo
Tron 对FullNode Api 测试并封装

## 地址操作
AddressConverTest: hex或base58地址,互相转换和验证

## 创建账户
AccountTest: 创建账户-->签名-->广播(broadcasttransaction)

## 资源
ResourceTest : 创建资源交易-->签名-->广播(broadcasttransaction)
### 资源测试
HighFrequencyQuery: 高频查询带宽
HighFrequencyTransfer: 高频快捷转账
ps: 两个类的main函数执行,观察带宽消耗情况

## 离线签名
TransactionSignDemo: 创建交易-->签名-->广播(broadcasthex)

## 普通转账
TransferTest: 创建交易-->签名-->广播(broadcasttransaction)