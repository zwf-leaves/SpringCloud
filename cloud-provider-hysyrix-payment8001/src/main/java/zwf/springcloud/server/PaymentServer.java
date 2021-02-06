package zwf.springcloud.server;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author zwf
 * @create 2021-01-08-22:37
 */
@Service
public class PaymentServer {
    public String paymentInfo_OK(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_OK,id"+id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_ErrorHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_Error(Integer id){
        int i=3;
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_Error,id"+id+"耗时（秒）"+i;
    }
    public String paymentInfo_ErrorHandler(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_ErrorHandler,id"+id+"嘿嘿";
    }
    //============熔断

    @HystrixCommand(fallbackMethod ="paymentCircuitBreaker_follback" ,commandProperties ={
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    } )
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("----id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return "线程池"+Thread.currentThread().getName()+"id:"+uuid;

    }

    public String paymentCircuitBreaker_follback(@PathVariable("id") Integer id){
        return "id不能为负数，请稍后再试，id："+id;
    }

}
