package com.hxb.dao.mapper;

import com.hxb.dao.entity.UserEntity;

import java.util.List;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-18 22:26:12
 */
public interface UserEntityMapper {
    /**
     * 新增用户
     * @param record 用户信息
     * @return 影响行数
     */
    int insert(UserEntity record);

    /**
     * 根据用户id查询用户信息
     * @param userId 用户id
     * @return 影响行数
     */
    UserEntity queryByUserId(Long userId);

    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<UserEntity> listAllUser();

    /**
     * 查询用户名的数量
     * @param username 用户名
     * @return 数量
     */
    boolean queryByUserName(String username);

    /**
     * 通过用户id修改非空字段
     * @param record 用户信息
     * @return 影响行数
     */
    int updateByUserIdSelective(UserEntity record);
}