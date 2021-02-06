package zwf.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zwf
 * @create 2021-01-08-15:45
 */
public interface LoadBlancer {
    ServiceInstance instance(List<ServiceInstance> instances);
}
