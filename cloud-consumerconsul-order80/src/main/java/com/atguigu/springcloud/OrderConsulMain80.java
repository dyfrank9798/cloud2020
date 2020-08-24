package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangrongchuan
 * @data 2020-08-2020/8/5-17:45
 * @Description
 * 在consul.exe文件夹内，打开控制体，输入下面命令
 * consul agent -dev
 * 输入localhost:8005即可展示consul的页面
 *
 * 相当于启动了Eureka的7001
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class,args);
    }
}
