package com.example.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A user detail information response view object
 *
 * @author Zhihong Miao
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailResVO {

    /**
     * user id
     */
    private Long id;

    /**
     * user name
     */
    private String userName;
}
