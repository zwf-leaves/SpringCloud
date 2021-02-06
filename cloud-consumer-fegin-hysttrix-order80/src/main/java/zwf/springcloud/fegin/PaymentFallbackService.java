package zwf.springcloud.fegin;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zwf
 * @create 2021-01-09-17:14
 */
@Component
public class PaymentFallbackService implements FeginHystrixPayment {
    @Override
    public String info_ok(Integer id) {
        return "----------------ok";
    }

    @Override
    public String info_error(Integer id) {
        return "-----------------error";
    }
}
