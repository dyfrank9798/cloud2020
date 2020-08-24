package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.PaymentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangrongchuan
 * @data 2020-08-2020/8/5-10:17
 * @Description DAO
 */
@Mapper
public interface PaymentDao {
    //add save create
    int create(PaymentEntity payment);

    PaymentEntity getPaymentById(@Param("id") long id);
}
