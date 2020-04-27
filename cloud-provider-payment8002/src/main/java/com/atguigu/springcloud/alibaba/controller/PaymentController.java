package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
 *@author:C1q
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private  String   serverPort;

    @PostMapping(value = "/payment/create")
    public  CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("###########插入结果"+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功,serverPort  "+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查找结果为: " + paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "查找成功,serverPort  "+serverPort, paymentById);
        } else {
            return new CommonResult(444, "查找为空,查找ID为: " + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public  String  getPaymentLB(){
        return serverPort;
    }
}
