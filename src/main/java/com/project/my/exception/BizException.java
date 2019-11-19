package com.project.my.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName BizException
 * @Description TODO
 * @Author mawei
 * @Date 2019/11/19 12:05 下午
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizException extends RuntimeException {

    private Integer code;

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
