package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.PaymentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhangrongchuan
 * @data 2020-08-2020/8/6-9:30
 * @Description
 */
@RestController
@Slf4j
public class OrderZkController {
    //    public static final String PAYMENT_URL = "http://localhost:8001";//单机版
//public static final String PAYMENT_URL = "http://cloud-payment-service";
//spring:
//    application:
//    name: cloud-payment-service
//    一个用户对应多个service。这里只识别name就可对应多个service

    public static final String INVOKE_URL = "http://cloud-provider-service";
    //调用资源，实例化
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String getPaymentInfo() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}
