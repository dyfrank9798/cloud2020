package myreler;

import com.netflix.loadbalancer.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author zhangrongchuan
 * @data 2020-09-2020/9/23-16:31
 * @Description
 *
 * com.netflix.loadbalancer.RoundRobinRule;轮询
 * com.netflix.loadbalancer.RandomRule;随机
 * com.netflix.loadbalancer.RetryRule;失败则会在指定时间内重试
 * WeightedResponseTimeRule() 扩展RoundRobinRule，响应速度越快，则权重越大，越容易被选择
 *
 *
 *
 */
@SpringBootApplication
public class Myself {
    @Bean
    public IRule myRuler(){
        new WeightedResponseTimeRule();
        new RandomRule();
        new RoundRobinRule();
        return new RetryRule();//定义为随机
    }
}
