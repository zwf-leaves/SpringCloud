package zwf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zwf
 * @create 2021-01-20-20:07
 */
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class Getway9527 {
    public static void main(String[] args) {

        SpringApplication.run(Getway9527.class,args);
    }
}
