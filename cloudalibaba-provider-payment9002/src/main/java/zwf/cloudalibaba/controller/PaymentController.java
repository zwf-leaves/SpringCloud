package zwf.cloudalibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwf
 * @create 2021-01-24-23:56
 */
@RestController
public class PaymentController {

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "9002传入的值是："+id;
    }
}
