package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

import javax.websocket.server.PathParam;

/*
 *@author:C1q
 */
@Mapper
public interface PaymentDao {

    public  int  create(Payment payment);

    public  Payment  getPaymentById(@PathParam("id") Long id);
}
