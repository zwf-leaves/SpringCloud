package zwf.cloudalibaba.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import zwf.springcloud.entities.CommonResult;
import zwf.springcloud.entities.Payment;

/**
 * @author zwf
 * @create 2021-01-30-18:04
 */
public class blockHandler {

    public static CommonResult exceptionHandler(BlockException exception){
        return new CommonResult(444,"按blockHandler限流测试error---1");
    }
    public static  CommonResult exceptionHandler2(BlockException exception){
        return new CommonResult(444,"按blockHandler限流测试error---2");
    }
}
