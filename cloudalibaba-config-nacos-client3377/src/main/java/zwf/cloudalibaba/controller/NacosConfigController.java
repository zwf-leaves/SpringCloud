package zwf.cloudalibaba.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwf
 * @create 2021-01-25-21:55
 */
@RestController
@RefreshScope
public class NacosConfigController {

    @Value("${config.info}")
    private String info;

    @Value("${a}")
    private String s;
    @GetMapping("/configInfo")
    public String getInfo(){
        return "port:3377,info:"+info+"---"+s;
    }

}
