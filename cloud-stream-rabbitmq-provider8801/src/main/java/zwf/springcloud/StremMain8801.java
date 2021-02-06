package zwf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zwf
 * @create 2021-01-23-22:51
 */
@SpringBootApplication
@EnableEurekaClient
public class StremMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StremMain8801.class,args);
    }
}
