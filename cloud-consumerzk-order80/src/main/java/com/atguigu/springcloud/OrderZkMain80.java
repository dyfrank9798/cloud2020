package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangrongchuan
 * @data 2020-08-2020/8/4-17:22
 * @Description
 * Zookeeper需要下载docker，下载docker之后安装zk
 * zk没有可视化页面。相当于启动zk之后，根据配置，两个ip地址(这个地址是docker的访问地址，虚拟机的地址)互相访问，将module注入zk中
 * 而Eureka和Consul是自定义配置地址
 *
 * docker pull zookeeper
 * docker run --privileged=true -d --name zookeeper --publish 2181:2181  -d zookeeper:latest
 * docker ps
 * docker respect e2d97ae4949c
 * docker inspect --format '{{ .NetworkSettings.IPAddress }}' e2d97ae4949c
 *
 * docker exec -it 容器id /bin/bash
 * cd bin
 * zkCli.sh
 * ls /services
 *
 * 使用Kitematic可视化工具可以直接用exec模式进入，不用获取id，之后往下操作即可
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient //向注册中心注册服务
public class OrderZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class,args);
    }
}
