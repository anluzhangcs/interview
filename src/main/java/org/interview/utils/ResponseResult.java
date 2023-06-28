package org.interview.utils;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.util.Objects;

/**
 * @author Manny
 * @create 2023-06-28-11:08
 */

@Data
@Accessors(chain = true)
public class ResponseResult<T> {

    private Integer code;
    private String message;
    private T data;

    //成功且没有数据返回
    public static ResponseResult ok() {
        return new ResponseResult()
                .setCode(HttpStatus.OK.value())
                .setMessage("操作成功");
    }

    //成功且有数据返回
    public static ResponseResult ok(Object data) {
        ResponseResult result = ok();
        if (Objects.nonNull(data)) {
            result.setData(data);
        }
        return result;
    }

    //失败
    public static ResponseResult failure(HttpStatus httpStatus) {
        return new ResponseResult()
                .setCode(httpStatus.value())
                .setMessage(httpStatus.getReasonPhrase());
    }

    public static ResponseResult failure(Integer code, String msg) {
        return new ResponseResult()
                .setCode(code)
                .setMessage(msg);
    }
}
