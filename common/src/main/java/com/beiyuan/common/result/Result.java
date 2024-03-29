package com.beiyuan.common.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: beiyuan
 * @date: 2022/11/2  16:41
 */
@Data
public class Result<T>{

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("信息")
    private String message;

    @ApiModelProperty("数据")
    private T data;


    public static<T> Result<T> ok(T data){
        Result<T> result=new Result<>();
        if(data!=null){
            result.setData(data);
        }
        result.setCode(20000);
        result.setMessage("success");
        return result;
    }

    public static<T> Result<T> bool(boolean isSuccess){
        if(isSuccess){
            return Result.ok(null);
        }
        return Result.fail(null);
    }

    public static<T> Result<T> fail(T data){
        Result<T> result=new Result<>();
        if(data!=null){
            result.setData(data);
        }
        result.setCode(40000);
        result.setMessage("fail");
        return result;
    }

    public Result<T> message(String message){
        this.setMessage(message);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }

}
