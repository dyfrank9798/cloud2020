package com.atguigu.springcloud.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhangrongchuan
 * @data 2020-08-2020/8/5-9:57
 * @Description 用于返回的接口
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data; //传入什么类型，返回什么类型
    public CommonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
