package zwf.springcloud.controller;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;


import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import zwf.springcloud.entities.CommonResult;
import zwf.springcloud.entities.Payment;
import zwf.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zwf
 * @create 2021-01-04-21:50
 */
@Slf4j
@RestController
public class PaymentController {
    @Resource
    PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;
    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info(""+i);
        System.out.println(i);
        System.out.println(i);
        if(i>0){
            return new CommonResult(200,"插入数据成功"+serverPort,i);
        }else{
            return new CommonResult(444,"插入数据失败"+serverPort,i);
        }

    }


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment byId = paymentService.getPaymentById(id);
        log.info("结果："+byId);
        if(byId!=null){
            return new CommonResult(200,"查询数据成功"+serverPort,byId);
        }else{
            return new CommonResult(444,"查询数据失败"+serverPort,byId);
        }

    }
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element:services){
           log.info("**********"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDE-PAYMENT");
        for (ServiceInstance instance:instances){
            log.info(instance.getPort()+"---"+instance.getUri()+"---"+instance.getHost()+"---"+instance.getInstanceId()+"---"+instance.getScheme()+"---"+instance.getServiceId());
        }
        return discoveryClient;
    }
    @GetMapping("/payment/lb")
    public String getPayment(){
        return serverPort;
    }
    @GetMapping("/payment/timeout")
    public String paymentFeginTimeout(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
    @GetMapping("/payment/zipkin")
    public String getZipkin(){
        return "zipkin";
    }

}
