package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.PaymentEntity;
import com.atguigu.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangrongchuan
 * @data 2020-08-2020/8/5-10:59
 * @Description
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    //比Autowire --spring resouce是java的
    private PaymentDao paymentDao;

    public int create(PaymentEntity payment){
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        payment.setTime(date);
        return paymentDao.create(payment);
    };

    public PaymentEntity getPaymentById(@Param("id") long id){
        return paymentDao.getPaymentById(id);
    };
}
