package com.pay.service;

import java.util.Map;

public interface WeixinPayService {

    /*
    * 生成二维码 接受二维码的参数
    * */
    //参数 商户订单号  标价金额
    public Map createNative(String out_trade_no,String total_fee);

    //查询订单状态
    public Map queryPayStatus(String out_trade_no);

    //关闭订单
    public Map closePay(String out_trade_no);
}
