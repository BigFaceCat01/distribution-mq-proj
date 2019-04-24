package com.hxb.common.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-24 17:52:02
 */
@Data
@Builder
public class UserSaveReq implements Serializable {
    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
}
