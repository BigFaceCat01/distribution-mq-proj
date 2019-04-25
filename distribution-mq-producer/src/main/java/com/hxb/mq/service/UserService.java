package com.hxb.mq.service;

import com.hxb.common.model.request.UserSaveReq;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-24 17:41:32
 */
public interface UserService {
    /**
     * 新增用户,没有幂等性验证，这里username需要非重复
     * @param saveReq 用户信息
     */
    void insertUser(UserSaveReq saveReq);

    /**
     * 新增用户,通过数据库增加字段版本号进行幂等性验证，这里username需要非重复
     * @param saveReq 用户信息
     */
    void insertUserWithRedis(UserSaveReq saveReq);
}
