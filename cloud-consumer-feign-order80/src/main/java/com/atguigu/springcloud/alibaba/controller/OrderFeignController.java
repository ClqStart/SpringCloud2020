package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.service.PaymentFeignService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
 *@author:C1q
 */
@RestController
@Slf4j
public class OrderFeignController {


    @Resource
    private PaymentFeignService paymentFeignService;

    @PostMapping(value = "/consumer/payment/create")
    public  CommonResult create(@RequestBody Payment payment){
       return paymentFeignService.create(payment);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public  String   paymentFeignTimeout(){
        return  paymentFeignService.paymentFeignTimeout();
    }

}
