package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

/**
 * @author zhangrongchuan
 * @data 2020-08-2020/8/24-17:38
 * @Description
 *
 *
 * 在consul.exe文件夹内，打开控制体，输入下面命令
 * consul agent -dev
 * 输入localhost:8005即可展示consul的页面
 *
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @RequestMapping(value="/payment/consul")
    public Object paymentConsul(){
        return "spring cloud with consul:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
