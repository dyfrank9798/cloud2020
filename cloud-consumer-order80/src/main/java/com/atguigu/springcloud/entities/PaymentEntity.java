package com.atguigu.springcloud.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhangrongchuan
 * @data 2020-08-2020/8/5-9:57
 * @Description  实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity implements Serializable {
    private Long id;
    private String serial;
}
