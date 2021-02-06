package zwf.cloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zwf
 * @create 2021-01-25-20:25
 */
@RestController
public class OrderController {

    @Resource
    RestTemplate restTemplate;

//    private static final String url="http://cloudalibaba-provider-payment";

    @Value("${service-url.nacos-user-service}")
    private  String url;
    @GetMapping("/order/nacos/{id}")
    public String getMessage(@PathVariable("id")Integer id){
        return restTemplate.getForObject(url+"/payment/nacos/"+id,String.class);
    }
}
