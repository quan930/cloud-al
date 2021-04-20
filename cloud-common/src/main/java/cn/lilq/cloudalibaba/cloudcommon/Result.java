package cn.lilq.cloudalibaba.cloudcommon;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @auther: Li Liangquan
 * @date: 2021/3/17 10:21
 */

@Data
@EqualsAndHashCode
@ToString
public class Result<T> implements Serializable {
    private boolean success = true;
    private Integer code;
    private String message;
    private T data;

    private Result(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public static <T> Result<T> success(T data,String msg) {
        Result<T> result = new Result<>(ReturnEnum.MSG_SUCCESS.getKey(), msg==null?ReturnEnum.MSG_SUCCESS.getValue():msg);
        result.data = data;
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(ReturnEnum.MSG_SUCCESS.getKey(),ReturnEnum.MSG_SUCCESS.getValue());
        result.data = data;
        return result;
    }

    public static <T> Result<T> fail(Integer code, String msg, T data) {
        Result<T> result =  new Result<>(code, msg);
        result.data = data;
        return result;
    }

    public static <T> Result<T> fail(Integer code, String msg) {
        return new Result<>(code, msg);
    }

    public static <T> Result<T> fail(ReturnEnum msgReturnEnum, T data) {
        Result<T> result = new Result<>(msgReturnEnum.getKey(), msgReturnEnum.getValue());
        result.data = data;
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
