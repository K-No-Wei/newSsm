package cn.knowei.ssm.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    // @ApiModelProperty(value = "是否成功")
    private Boolean success;
    // @ApiModelProperty(value = "响应码")
    private Integer code;
    // @ApiModelProperty(value = "响应信息")
    private String message;
    // @ApiModelProperty(value = "响应数据")
//    private T Data;
    private Map<String, T> data = new HashMap<>();

    /**
     * 成功
     * @return
     */
    public static <V> Result<V> success(){
        Result<V> result = new Result<>();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        return result;
    }

    /**
     * 失败
     * @return
     */
    public static <V> Result<V> failure(){
        Result<V> result = new Result<>();
        result.setSuccess(true);
        result.setCode(ResultCode.ERROR.getCode());
        result.setMessage(ResultCode.ERROR.getMessage());
        return result;
    }

    /**
     * 链式编程
     * @param success
     * @return
     */

    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result data(Map<String, T> map){
        this.data = map;
        return this;
    }

    public Result data(String key, T value){
        this.data.put(key, value);
        return this;
    }


}
