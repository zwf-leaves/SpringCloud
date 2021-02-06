package zwf.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import zwf.springcloud.FeginHystrixOrderMain80;
import zwf.springcloud.fegin.FeginHystrixPayment;

import javax.annotation.Resource;

/**
 * @author zwf
 * @create 2021-01-08-23:44
 */
@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class PaymentController {
    @Resource
    FeginHystrixPayment feginHystrixPayment;

    @GetMapping("/fegin/hystrix/ok/{id}")
    public String OK(@PathVariable("id") Integer id){
        return feginHystrixPayment.info_ok(id);
    }

    @GetMapping("/fegin/hystrix/error/{id}")
//    @HystrixCommand(fallbackMethod = "ErrorHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "50000")
//    })
   // @HystrixCommand
    public String Error(@PathVariable("id") Integer id){
        //int x=10/0;
        return feginHystrixPayment.info_error(id);
    }

    public String ErrorHandler(@PathVariable("id") Integer id){
        return "出错了，请稍后再试";
    }

    /**
     * 全局fallback
     *
     * @return
     */
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息,请稍后重试.o(╥﹏╥)o";
    }

}
