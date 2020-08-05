package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.PaymentEntity;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhangrongchuan
 * @data 2020-08-2020/8/5-11:13
 * @Description
 */
@RestController
// == @ResponseBody ＋ @Controller
public class PaymentController {
    @Resource
    private PaymentService paymentService;

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
    public CommonResult create(PaymentEntity paymentEntity){
        int result = paymentService.create(paymentEntity);
        System.out.println("************插入结果"+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功",result);
        }else{
            return new CommonResult(444,"插入数据库失败！",null);
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentByid(@PathVariable("id") Long id){
        PaymentEntity paymentEntity = paymentService.getPaymentById(id);

        System.out.println("************插入结果"+paymentEntity);
        if(paymentEntity != null){
            return new CommonResult(200,"查询成功",paymentEntity);
        }else{
            return new CommonResult(444,id+"查询失败",null);
        }
    }
}
