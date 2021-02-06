import org.junit.jupiter.api.Test;
import zwf.springcloud.entities.CommonResult;

/**
 * @author zwf
 * @create 2021-01-04-23:30
 */
public class A {
    @Test
    public void t(){
        CommonResult result = new CommonResult();
        result.setCode(200);
        System.out.println(result.getCode());
    }
}
