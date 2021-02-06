package zwf.cloudalibaba.controller;



import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zwf
 * @create 2021-01-27-14:40
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        System.out.println("test--------------testA");
        return "------testA";
    }
    @GetMapping("/testB")
    public String testB(){
        System.out.println("test--------------testB");
        return "------testB";
    }
    @GetMapping("/testC")
    public String testC(){
//        try {
////            Thread.sleep(500);
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("testC,测试RT");
        log.info("testC,测试异常比例");
        int random =((int) Math.random()*100)%2;
        int c=6/0;
        return "------testC";
    }

    @GetMapping("/testD")

    public String testD(){

        log.info("test 异常数");
        int c=6/0;
        return "------testD";
    }

    @GetMapping("/testE")
    @SentinelResource(value = "testE",blockHandler = "deal_testE")
    public String testE(@RequestParam(value = "p1",required = false) String p1,
                        @RequestParam(value = "p1",required = false) String p2){
        log.info("test 异常数"+p1);
        return "------testE";
    }

    public String deal_testE(String p1, String p2, BlockException e){
        return "------deal_testE";
    }

}
