package com.example.controller;

import com.example.handler.BizException;
import com.example.model.req.AddUserReqVO;
import com.example.model.res.UserDetailResVO;
import com.example.result.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * user controller
 *
 * @author Zhihong Miao
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("/{id}")
    public ApiResult<UserDetailResVO> get(@PathVariable Long id) {
        if (id > 0) {
            UserDetailResVO userDetailResVO = UserDetailResVO.builder().id(id).userName("tom").build();
            return ApiResult.success(userDetailResVO);
        }
        throw new BizException("invalid param, id must greater than 0");
    }

    @PostMapping
    public ApiResult<Long> save(@RequestBody @Valid AddUserReqVO reqVO) {
        log.info("userName:{}", reqVO.getUserName());
        return ApiResult.success(1L);
    }

}
