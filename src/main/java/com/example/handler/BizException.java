package com.example.handler;

import com.example.result.CommonResultCode;
import com.example.result.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * business exception
 *
 * @author Zhihong Miao
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException {

    /**
     * status code
     */
    private Integer code;

    /**
     * status message
     */
    private String message;

    /**
     * Constructs a BizException whit {@link ResultCode}
     *
     * @param resultCode A {@link ResultCode}
     */
    public BizException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    /**
     * Constructs a BizException whit a message
     *
     * @param message A custom message
     */
    public BizException(String message) {
        this.code = CommonResultCode.FAILED.getCode();
        this.message = message;
    }

    /**
     * Constructs a BizException whit a code and a message
     *
     * @param code A custom code
     * @param message A custom message
     */
    public BizException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
