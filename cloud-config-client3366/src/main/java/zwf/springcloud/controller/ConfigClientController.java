package zwf.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwf
 * @create 2021-01-21-20:43
 */
@RestController
@RefreshScope
public class ConfigClientController {


    @Value("${server.port}")
    private String port;
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/get")
    public String getConfigInfo(){
        return configInfo+port;
    }
}
