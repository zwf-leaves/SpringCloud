package zwf.springcloud.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zwf
 * @create 2021-01-08-23:42
 */
@Component
@FeignClient(name = "cloud-provider-hysyrix-payment",fallback = PaymentFallbackService.class)
public interface FeginHystrixPayment {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String info_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/error/{id}")
    public String info_error(@PathVariable("id") Integer id);
}
