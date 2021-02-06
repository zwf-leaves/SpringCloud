package zwf.cloudalibaba.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zwf
 * @create 2021-01-30-21:26
 */
@Component
@FeignClient(name = "cloudalibab-provider-payment",fallback = FallbackMethod.class)
public interface OrderFegin {

    @GetMapping("/getport")
    public String getPort();
}
