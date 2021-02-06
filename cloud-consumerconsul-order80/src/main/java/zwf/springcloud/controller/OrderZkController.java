package zwf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zwf
 * @create 2021-01-05-17:00
 */
@Slf4j
@RestController
public class OrderZkController {
    //private static final String PAYMENT_URL="http://localhost:8001";
    private static final String PAYMENT_URL="http://consul-provide-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String getPayment(){
        String object = restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
        return object;
    }

}
