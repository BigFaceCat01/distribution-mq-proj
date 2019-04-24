package com.hxb.dao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
/**
 * @author Created by huang xiao bao
 * @date 2019-04-18 22:26:12
 */
@Data
@Accessors(chain = true)
public class UserEntity {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 密码
     */
    private String password;
    /**
     * 修改时间
     */
    private Date modifyTime;
}