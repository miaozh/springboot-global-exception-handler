package com.example.result;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * common result status code
 *
 * @author Zhihong Miao
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CommonResultCode implements ResultCode {

    /**
     * success
     */
    SUCCESS(0, "success"),

    /**
     * invalid param
     */
    INVALID_PARAM(4000, "invalid param"),

    /**
     * failed
     */
    FAILED(5000, "failed");

    /**
     * status code
     */
    private final Integer code;

    /**
     * status message
     */
    private final String message;
}
