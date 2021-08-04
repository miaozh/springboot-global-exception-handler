package com.example.result;

/**
 * result status code interface
 *
 * @author Zhihong Miao
 */
public interface ResultCode {
    
    /**
     * Get status code
     *
     * @return status code
     */
    Integer getCode();

    /**
     * Get status message
     *
     * @return status message
     */
    String getMessage();
}
