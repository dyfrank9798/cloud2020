package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.PaymentEntity;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author zhangrongchuan
 * @data 2020-08-2020/8/5-11:13
 * @Description
 */
@RestController
// == @ResponseBody ＋ @Controller
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;
    /**
     *
     * @PostMapping用于将HTTP post请求映射到特定处理程序的方法注解
     *
     * 具体来说，@PosMapping是一个组合注解，是@RequestMapping(method=RequestMethod.POST)的缩写
     *
     *请求资源应该使用GET
     *
     * 添加资源应该使用POST
     *
     * 更新资源应该使用PUT
     *
     * 删除资源应该使用DELETE
     */
    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody PaymentEntity paymentEntity){
        int result = paymentService.create(paymentEntity);
        System.out.println("************插入结果"+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功,serverport:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败！",null);
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentByid(@PathVariable("id") Long id){
        PaymentEntity paymentEntity = paymentService.getPaymentById(id);
        System.out.println("热部署");
        System.out.println("************查询结果"+paymentEntity);
        if(paymentEntity != null){
            return new CommonResult(200,"查询成功,serverport:"+serverPort,paymentEntity);
        }else{
            return new CommonResult(444,id+"查询失败",null);
        }
    }

    /**
     *
     * @return
     *                                          寻找
     * (80或者其他的服务)利用/payment/discovery  ----->>>>   8001,8002
     *
     */
    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        //所有微服务
        List<String> services =  discoveryClient.getServices();
        for(String service :services){
            System.out.println(service);
        }
        //这个微服务下面的实例：8001,8002
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance :instances){
            System.out.println(instance.getServiceId());
            System.out.println(instance.getHost());
            System.out.println(instance.getPort());
            System.out.println(instance.getUri());
        }
        return this.discoveryClient;
    }

    @RequestMapping(value="/payment/zk")
    public Object paymentzk(){

        return "spring cloud with zookeeper"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
