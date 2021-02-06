package zwf.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zwf.cloudalibaba.fegin.OrderFegin;

import javax.annotation.Resource;

/**
 * @author zwf
 * @create 2021-01-30-21:19
 */
@RestController
public class OrderController {

    @Resource
    OrderFegin orderFegin;
    private String URL="http://cloudalibab-provider-payment";

    @Resource
    RestTemplate restTemplate;
    @GetMapping("/get")
    @SentinelResource(value = "get",fallback = "handlerExpection",exceptionsToIgnore = ArithmeticException.class)
    public String getPort()  {
        return restTemplate.getForObject(URL+"/getport",String.class);
    }
    @GetMapping("/get1")
    public String getPort1(){
        return orderFegin.getPort();
    }
    public String handlerExpection(Throwable e){
        return "到handlerExpection了"+e.getClass().getName();
    }
}
