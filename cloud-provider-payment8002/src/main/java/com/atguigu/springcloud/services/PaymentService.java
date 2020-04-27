package com.atguigu.springcloud.services;

import com.atguigu.springcloud.entities.Payment;

import javax.websocket.server.PathParam;

/*
 *@author:C1q
 */
public interface PaymentService {
    public  int  create(Payment payment);

    public  Payment  getPaymentById(@PathParam("id") Long id);
}
