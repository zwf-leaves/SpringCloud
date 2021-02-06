package zwf.cloudalibaba.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zwf.cloudalibaba.domain.CommonResult;

import java.math.BigDecimal;

/**
 * @author Dark
 * @date 2020-08-02 14:28
 */
@FeignClient(value = "seata-account-service")
public interface AccountService{
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
