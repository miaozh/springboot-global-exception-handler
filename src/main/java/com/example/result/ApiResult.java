package com.example.result;

import lombok.Data;

/**
 * api result class
 *
 * @author Zhihong Miao
 */
@Data
public class ApiResult<T> {

    /**
     * status code
     */
    private Integer code;

    /**
     * status message
     */
    private String message;

    /**
     * result data
     */
    private T data;

    /**
     * Get success result
     *
     * @return A success result
     */
    public static <T> ApiResult<T> success() {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(CommonResultCode.SUCCESS.getCode());
        apiResult.setMessage(CommonResultCode.SUCCESS.getMessage());
        return apiResult;
    }

    /**
     * Get success result with data
     *
     * @param data Request required data
     * @return A success result
     */
    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(CommonResultCode.SUCCESS.getCode());
        apiResult.setMessage(CommonResultCode.SUCCESS.getMessage());
        apiResult.setData(data);
        return apiResult;
    }

    /**
     * Get failed result
     *
     * @return A failed result
     */
    public static <T> ApiResult<T> failed() {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(CommonResultCode.FAILED.getCode());
        apiResult.setMessage(CommonResultCode.FAILED.getMessage());
        return apiResult;
    }

    /**
     * Get failed result whit custom message
     *
     * @param message Custom message
     * @return A failed result
     */
    public static <T> ApiResult<T> failed(String message) {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(CommonResultCode.FAILED.getCode());
        apiResult.setMessage(message);
        return apiResult;
    }

    /**
     * Get failed result whit custom code and message
     *
     * @param code Custom code
     * @param message Custom message
     * @return A failed result
     */
    public static <T> ApiResult<T> failed(Integer code, String message) {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(code);
        apiResult.setMessage(message);
        return apiResult;
    }

    /**
     * Get failed result whit {@link ResultCode}
     *
     * @param resultCode Custom ResultCode
     * @return A failed result
     */
    public static <T> ApiResult<T> failed(ResultCode resultCode) {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(resultCode.getCode());
        apiResult.setMessage(resultCode.getMessage());
        return apiResult;
    }

    /**
     * Get failed result whit {@link ResultCode} and data
     *
     * @param resultCode Custom ResultCode
     * @param data Request required data
     * @return A failed result
     */
    public static <T> ApiResult<T> failed(ResultCode resultCode, T data) {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(resultCode.getCode());
        apiResult.setMessage(resultCode.getMessage());
        apiResult.setData(data);
        return apiResult;
    }
}
