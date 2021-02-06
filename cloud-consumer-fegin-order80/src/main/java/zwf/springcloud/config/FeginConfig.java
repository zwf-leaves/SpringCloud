package zwf.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zwf
 * @create 2021-01-08-21:23
 */
@Configuration
public class FeginConfig {

    @Bean
    Logger.Level feginLoggerLevel(){
        return Logger.Level.FULL;
    }
}
