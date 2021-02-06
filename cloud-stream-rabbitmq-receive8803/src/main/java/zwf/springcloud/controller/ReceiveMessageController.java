package zwf.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/**
 * @author zwf
 * @create 2021-01-24-0:26
 */
@Controller
@EnableBinding(Sink.class)
public class ReceiveMessageController {
    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message){
        System.out.println(message.getPayload()+"-------"+port);

    }
}
