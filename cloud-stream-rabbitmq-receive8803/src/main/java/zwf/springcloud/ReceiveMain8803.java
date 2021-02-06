package zwf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zwf
 * @create 2021-01-24-0:32
 */
@SpringBootApplication
@EnableEurekaClient
public class ReceiveMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(ReceiveMain8803.class,args);
    }
}
