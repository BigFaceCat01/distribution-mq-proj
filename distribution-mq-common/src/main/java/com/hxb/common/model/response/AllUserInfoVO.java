package com.hxb.common.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-18 22:26:12
 */
@Data
public class AllUserInfoVO implements Serializable {
    /**
     * 用户id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("用户id")
    private Long userId;
    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date modifyTime;
}