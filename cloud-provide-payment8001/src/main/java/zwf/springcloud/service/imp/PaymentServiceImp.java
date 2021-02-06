package zwf.springcloud.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zwf.springcloud.dao.PaymentDao;
import zwf.springcloud.entities.Payment;
import zwf.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author zwf
 * @create 2021-01-04-21:46
 */
@Service
public class PaymentServiceImp implements PaymentService {

    //@Autowired
    @Resource
    PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
