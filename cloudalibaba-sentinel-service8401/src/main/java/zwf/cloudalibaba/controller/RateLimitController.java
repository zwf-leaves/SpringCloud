package zwf.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import javafx.beans.DefaultProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zwf.cloudalibaba.myHandler.blockHandler;
import zwf.springcloud.entities.CommonResult;
import zwf.springcloud.entities.Payment;

/**
 * @author zwf
 * @create 2021-01-30-17:29
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "deal_byResource")
    public CommonResult byResource(){
        log.info("test 异常数");
        return new CommonResult(200,"按资源名称限流测试ok",new Payment(2020l,"serial"));
    }

    public CommonResult deal_byResource( BlockException e){
        return new CommonResult(444,e.getClass().getCanonicalName()+"服务不可用");
    }
    @GetMapping("/url")
    @SentinelResource(value = "url")
    public CommonResult url(){
        log.info("test 异常数");
        return new CommonResult(200,"按url限流测试ok",new Payment(2020l,"serial"));
    }
    @GetMapping("/blockHandler")
    @SentinelResource(value = "blockHandler",blockHandlerClass = blockHandler.class,blockHandler = "exceptionHandler")
    public CommonResult blockHandler(){
        log.info("test 异常数");
        return new CommonResult(200,"按blockHandler限流测试ok",new Payment(2020l,"serial"));
    }
}
