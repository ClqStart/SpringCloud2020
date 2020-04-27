package com.atguigu.springcloud.alibaba.dao;

/*
 *@author:C1q
 */

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface StorageDao {


    //扣减库存信息
    @Transactional
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}

