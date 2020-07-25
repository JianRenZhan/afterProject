package com.pay.controller;


import com.pay.service.WeixinPayService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private WeixinPayService weixinPayService;
    private String outTradeNo = "123456";

    private Long totalFee = new Long(1);

    @RequestMapping("/createNative")
    public Map createNative(){
        //提取支付日志（从缓存中）
        return weixinPayService.createNative(outTradeNo,totalFee+"");
    }


    @RequestMapping("/queryPayStatus")
    public Result queryPayStatus(String out_trade_no){
        Result result = null;
        int x = 0;
        while (true){
            Map<String,String> map = weixinPayService.queryPayStatus(out_trade_no);
            if(map == null){
                result = new Result(false,"支付发生异常");
                break;
            }
            if(map.get("trade_state").equalsIgnoreCase("success")){
                result = new Result(true,"支付成功");

                //orderService.updateOrderStatus(out_trade_no, map.get("transaction_id"));
                break;
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x ++;
            if(x >= 100){
                result = new Result(false,"二维码超时");
                break;
            }
        }
        return result;
    }
}
