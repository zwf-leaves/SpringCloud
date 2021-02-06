package zwf.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import zwf.springcloud.entities.CommonResult;
import zwf.springcloud.entities.Payment;
import zwf.springcloud.fegin.PaymentFegin;

import javax.annotation.Resource;

/**
 * @author zwf
 * @create 2021-01-08-17:55
 */
@RestController
public class OrderFeginController {
    @Resource
    PaymentFegin paymentFegin;

    @GetMapping("/fegin/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommonResult<Payment> payment= paymentFegin.getPaymentById(id);
        return payment;
    }
    @GetMapping("/fegin/payment/timeout")
    public String paymentFeginTimeout(){
        return paymentFegin.paymentFeginTimeout();
    }
}
