package com.example.handler;

import com.example.result.ApiResult;
import com.example.result.CommonResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * global exception handler
 *
 * @author Zhihong Miao
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handler business exception
     *
     * @param e BizException
     * @return Encapsulated ApiResult
     */
    @ExceptionHandler(BizException.class)
    public ApiResult<Object> bizExceptionHandler(BizException e) {
        log.error("Business exception", e);
        return ApiResult.failed(e.getCode(), e.getMessage());
    }

    /**
     * Handler param not valid exception
     *
     * @param e MethodArgumentNotValidException
     * @return Encapsulated ApiResult
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult<Object> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("Param not valid exception", e);
        List<ObjectError> objectErrorList = e.getBindingResult().getAllErrors();
        if (CollectionUtils.isEmpty(objectErrorList)) {
            return ApiResult.failed(CommonResultCode.INVALID_PARAM);
        }
        List<String> messageList = objectErrorList.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        return ApiResult.failed(CommonResultCode.INVALID_PARAM, messageList);
    }

    /**
     * Handler param not valid exception
     *
     * @param e HttpMessageNotReadableException
     * @return Encapsulated ApiResult
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ApiResult<Object> httpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("param not valid exception", e);
        return ApiResult.failed(CommonResultCode.INVALID_PARAM);
    }

    /**
     * Handler request method not supported exception
     *
     * @param e HttpRequestMethodNotSupportedException
     * @return Encapsulated ApiResult
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ApiResult<Object> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("Request method not supported.", e);
        return ApiResult.failed(CommonResultCode.INVALID_REQUEST_METHOD);
    }

    /**
     * Handler other exception
     *
     * @param e Exception
     * @return Encapsulated ApiResult
     */
    @ExceptionHandler(Exception.class)
    public ApiResult<Object> exceptionHandler(Exception e) {
        log.error("Server exception", e);
        return ApiResult.failed();
    }
}
