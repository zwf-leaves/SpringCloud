package zwf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import zwf.springcloud.server.PaymentServer;

import javax.annotation.Resource;

/**
 * @author zwf
 * @create 2021-01-08-22:44
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentServer paymentServer;
    @Value("${server.port}")
    String port;
    @GetMapping("/payment/hystrix/ok/{id}")
    public String info_ok(@PathVariable("id") Integer id){
       return port+paymentServer.paymentInfo_OK(id);
    }
    @GetMapping("/payment/hystrix/error/{id}")
    public String info_error(@PathVariable("id") Integer id){
        log.info("结果："+id);
        return port+paymentServer.paymentInfo_Error(id);
    }

    @GetMapping("/payment/circute/{id}")
    public String paymentCircute(@PathVariable("id") Integer id){
        String breaker = paymentServer.paymentCircuitBreaker(id);
        return breaker;
    }
}
