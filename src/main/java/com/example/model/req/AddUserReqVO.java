package com.example.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Add a user request param view object
 *
 * @author Zhihong Miao
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddUserReqVO {

    /**
     * user name
     */
    @NotBlank(message = "Username can not be blank")
    private String userName;

    /**
     * user age
     */
    @NotNull(message = "User age can not be null")
    private Integer age;
}
