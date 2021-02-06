package zwf.springcloud.service;

import org.apache.ibatis.annotations.Param;
import zwf.springcloud.entities.Payment;

/**
 * @author zwf
 * @create 2021-01-04-21:44
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
