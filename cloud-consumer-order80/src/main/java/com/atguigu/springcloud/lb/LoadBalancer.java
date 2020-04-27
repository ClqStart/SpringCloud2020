package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/*
 *@author:C1q
 */
public interface LoadBalancer {
    ServiceInstance  instance(List<ServiceInstance> serviceInstances);
}
