package zwf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zwf
 * @create 2021-01-06-19:14
 */
@EnableEurekaServer
@SpringBootApplication
public class ServerMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(ServerMain7002.class,args);
    }
}
