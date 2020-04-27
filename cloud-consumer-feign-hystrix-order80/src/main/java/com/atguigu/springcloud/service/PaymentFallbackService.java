package com.atguigu.springcloud.service;

/*
 *@author:C1q
 */


import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "=========================PaymentFallbackService fall  back-paymentInfo_ok=======";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "=========================PaymentFallbackService fall  back-paymentInfo_TimeOut=======";
    }
}
