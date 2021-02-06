package zwf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zwf
 * @create 2021-01-06-16:04
 */
@SpringBootApplication
@EnableEurekaServer
public class ServerMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(ServerMain7001.class,args);
    }
}
