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
     * Success
     */
    SUCCESS(0, "Success"),

    /**
     * Invalid param
     */
    INVALID_PARAM(4000, "Invalid param"),

    /**
     * Request method not supported
     */
    INVALID_REQUEST_METHOD(4100, "Request method not supported"),

    /**
     * Failed
     */
    FAILED(5000, "Failed");

    /**
     * status code
     */
    private final Integer code;

    /**
     * status message
     */
    private final String message;
}
