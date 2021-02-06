package zwf.cloudalibaba.fegin;

import org.springframework.stereotype.Component;

/**
 * @author zwf
 * @create 2021-01-30-22:52
 */
@Component
public class FallbackMethod implements OrderFegin {
    @Override
    public String getPort() {
        return "到FallbackMethod了";
    }
}
