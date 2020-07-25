package com.pay.service.impl;

import com.github.wxpay.sdk.WXPayUtil;
import com.pay.util.HttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeixinPayServiceImpl implements com.pay.service.WeixinPayService {



    @Value("${wx.appid}")
    private String appid;// 微信公众账号或开放平台 APP 的唯一标识
    @Value("${wx.partner}")
    private String partner;// 财付通平台的商户账号
    @Value("${wx.partnerkey}")
    private String partnerkey;//财付通平台的商户密钥


    @Override
    public Map createNative(String out_trade_no, String total_fee) {
        //1. 封装结果
        Map<String,String> map = new HashMap();
        map.put("appid",appid);//公众账号ID
        map.put("mch_id",partner);//商户号
        map.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串
       // map.put("sign","");//签名 能够自动生成
        map.put("body","品");//商品描述
        map.put("out_trade_no",out_trade_no);//商户订单号
        map.put("total_fee",total_fee);//标价金额
        map.put("spbill_create_ip","127.0.0.1");//终端ip
        map.put("notify_url","http://test.itcast.cn");//通知地址
        map.put("trade_type","NATIVE");//交易类型

        try {
            String paramXml = WXPayUtil.generateSignedXml(map, partnerkey);

            //2. 发送请求
            HttpClient httpClient = new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");
           // HttpClient httpClient = new HttpClient("https://api2.mch.weixin.qq.com/pay/micropay");
            httpClient.setHttps(true);
            httpClient.setXmlParam(paramXml);
            httpClient.post();
            //3. 接收参数
            String resultXml = httpClient.getContent();
            Map<String, String> resultMap = WXPayUtil.xmlToMap(resultXml);
            Map<String,String> map1 = new HashMap();
            map1.put("code_url",resultMap.get("code_url"));//支付地址
            map1.put("total_fee",total_fee);//表价金额
            map1.put("out_trade_no",out_trade_no);//订单号
            return map1;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap();
        }
    }

    //关闭订单
    @Override
    public Map closePay(String out_trade_no) {
        //1.封装参数
        Map<String,String> param = new HashMap<>();
        param.put("appid",appid);//公众账号ID
        param.put("mch_id",partner);//商户号
        param.put("out_trade_no",out_trade_no);//商户订单号
        param.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串

        try {
            String paramXml = WXPayUtil.generateSignedXml(param, partnerkey);//自动生成签名
            //2.发送请求
            HttpClient httpClient = new HttpClient("https://api.mch.weixin.qq.com/pay/closeorder");
            httpClient.setHttps(true);
            httpClient.setXmlParam(paramXml);
            httpClient.post();

            //3. 接收参数
            String resultXml = httpClient.getContent();
            Map<String, String> resultMap = WXPayUtil.xmlToMap(resultXml);
            return resultMap;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map queryPayStatus(String out_trade_no) {
        //1.封装参数
        Map<String,String> param = new HashMap<>();
        param.put("appid",appid);//公众账号ID
        param.put("mch_id",partner);//商户号
        param.put("out_trade_no",out_trade_no);//商户订单号
        param.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串

        try {
            String paramXml = WXPayUtil.generateSignedXml(param, partnerkey);//自动生成签名
            //2.发送请求
            HttpClient httpClient = new HttpClient("https://api.mch.weixin.qq.com/pay/orderquery");
            httpClient.setHttps(true);
            httpClient.setXmlParam(paramXml);
            httpClient.post();

            //3. 接收参数
            String resultXml = httpClient.getContent();
            Map<String, String> resultMap = WXPayUtil.xmlToMap(resultXml);
            return resultMap;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
