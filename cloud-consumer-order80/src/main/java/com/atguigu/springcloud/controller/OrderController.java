package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.PaymentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
public class OrderController {
//    public static final String PAYMENT_URL = "http://localhost:8001";//单机版
public static final String PAYMENT_URL = "http://cloud-payment-service";
//spring:
//    application:
//    name: cloud-payment-service
//    一个用户对应多个service。这里只识别name就可对应多个service
    //调用资源，实例化
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<PaymentEntity> create(PaymentEntity payment) {
        System.out.println(payment);
//        restTemplate
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
//        return restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class).getBody();
    }

    @GetMapping("/consumer/payment/get/{id}")
///"sale_prj/{salePrjId}?page={page}&rows={rows}"
    public CommonResult<PaymentEntity> getPayment(@PathVariable("id") Long id) {
        System.out.println(id);
//        restTemplate
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
//        return restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class).getBody();
    }


    @GetMapping("/consumer/payment/createForEntity")
    public CommonResult<PaymentEntity> create2(PaymentEntity payment) {
        System.out.println(payment);
        ResponseEntity<CommonResult> entity =restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<PaymentEntity> getPayment2(@PathVariable("id") Long id) {
        System.out.println(id);
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }
    }
}
