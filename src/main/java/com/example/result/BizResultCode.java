package com.example.result;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * business result status code
 *
 * @author Zhihong Miao
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum BizResultCode implements ResultCode {

    /**
     * account freeze
     */
    ACCOUNT_FREEZE(10000, "The account is frozen");

    /**
     * status code
     */
    private final Integer code;

    /**
     * status message
     */
    private final String message;
}
