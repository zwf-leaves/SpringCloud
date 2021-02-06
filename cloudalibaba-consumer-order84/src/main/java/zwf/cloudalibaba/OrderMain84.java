package zwf.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zwf
 * @create 2021-01-30-21:11
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"zwf.cloudalibaba.fegin"})
public class OrderMain84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain84.class,args);
    }
}
