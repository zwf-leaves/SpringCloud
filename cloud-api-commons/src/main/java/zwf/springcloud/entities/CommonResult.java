package zwf.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zwf
 * @create 2021-01-04-21:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 134343433L;

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
       this(code,message,null);
    }
}
