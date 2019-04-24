package com.hxb.mq.service;

import com.hxb.common.model.request.UserSaveReq;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-24 17:41:32
 */
public interface UserService {
    /**
     * 新增用户
     * @param saveReq 用户信息
     */
    void insertUser(UserSaveReq saveReq);
}
