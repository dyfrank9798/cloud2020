package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.PaymentEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangrongchuan
 * @data 2020-08-2020/8/5-10:59
 * @Description
 */
public interface PaymentService {

    public int create(PaymentEntity payment);

    public PaymentEntity getPaymentById(@Param("id") long id);
}
