package zwf.cloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dark
 * @date 2020-08-02 14:45
 */
@Configuration
@MapperScan({"zwf.cloudalibaba.dao"})
public class MyBatisConfig {

}
