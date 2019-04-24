package com.hxb.mq.service.impl;

import com.hxb.common.model.request.UserSaveReq;
import com.hxb.dao.entity.UserEntity;
import com.hxb.dao.mapper.UserEntityMapper;
import com.hxb.mq.service.UserService;
import com.hxb.structure.util.BeanConvertUtils;
import com.hxb.structure.util.Md5Utils;
import com.hxb.structure.util.SnowFlakesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-24 17:41:46
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserEntityMapper userEntityMapper;

    @Override
    public void insertUser(UserSaveReq saveReq){
        UserEntity userEntity = BeanConvertUtils.convert(saveReq, UserEntity.class);
        userEntity.setPassword(Md5Utils.md5(userEntity.getPassword()))
                .setCreateTime(new Date())
                .setUserId(SnowFlakesUtil.nextId());
        userEntityMapper.insert(userEntity);
    }
}
