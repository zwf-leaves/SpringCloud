package zwf.springcloud.service.impl;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

import org.springframework.messaging.support.MessageBuilder;
import zwf.springcloud.service.MessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author zwf
 * @create 2021-01-23-22:56
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements MessageProvider {

    @Resource
    private MessageChannel output;
    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        boolean send = output.send(MessageBuilder.withPayload(s).build());
        System.out.println(s);
     return null;
    }
}















