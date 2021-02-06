package zwf.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zwf
 * @create 2021-01-07-22:18
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule randomRule(){
       return new RandomRule();
    }
}
