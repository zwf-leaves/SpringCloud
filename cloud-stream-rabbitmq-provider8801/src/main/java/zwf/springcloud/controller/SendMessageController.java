package zwf.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zwf.springcloud.service.MessageProvider;

import javax.annotation.Resource;

/**
 * @author zwf
 * @create 2021-01-23-23:14
 */
@RestController
public class SendMessageController {

    @Resource
    private MessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
