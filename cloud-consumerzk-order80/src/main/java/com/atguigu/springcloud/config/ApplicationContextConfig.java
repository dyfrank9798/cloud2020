package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangrongchuan
 * @data 2020-08-2020/8/6-9:54
 * @Description 注入到容器
 *
 * 订单Order的Controller不像之前springboot一样在一个Module里
 * 这里需要用resttemplate来调用支付Payment的Module
 * 所以需要先将resttemplate注入到容器中使用
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //    application.xml <bean id="" class=""  />
    @LoadBalanced
    //负载均衡：默认为轮询。1,2端口交替出现
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
