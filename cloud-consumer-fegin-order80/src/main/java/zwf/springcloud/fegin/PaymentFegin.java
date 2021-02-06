package zwf.springcloud.fegin;

import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import zwf.springcloud.entities.CommonResult;
import zwf.springcloud.entities.Payment;

/**
 * @author zwf
 * @create 2021-01-08-17:48
 */
@Component
@FeignClient(name = "CLOUD-PROVIDE-PAYMENT")
public interface PaymentFegin {

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    public String paymentFeginTimeout();
}
