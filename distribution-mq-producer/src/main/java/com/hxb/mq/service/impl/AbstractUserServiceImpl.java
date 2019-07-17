package com.hxb.mq.service.impl;

import com.hxb.common.model.request.UserSaveReq;
import com.hxb.dao.entity.UserEntity;
import com.hxb.dao.mapper.UserEntityMapper;
import com.hxb.mq.aop.ParamLog;
import com.hxb.mq.exception.BusinessException;
import com.hxb.mq.service.AbstractUserService;
import com.hxb.structure.util.BeanConvertUtils;
import com.hxb.structure.util.Md5Utils;
import com.hxb.structure.util.SnowFlakesUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Created by huang xiao bao
 * @date 2019-07-04 14:43:34
 */
@Service
public class AbstractUserServiceImpl extends AbstractUserService {
    @Resource
    private UserEntityMapper userEntityMapper;

    @Override
    @ParamLog
    @Transactional(rollbackFor = Exception.class)
    public void insertUser(UserSaveReq saveReq) {
        boolean contain = userEntityMapper.queryByUserName(saveReq.getUserName());
        if(contain){
            throw new BusinessException("repeat user name !!!",saveReq.getUserName());
        }
        UserEntity userEntity = BeanConvertUtils.convert(saveReq, UserEntity.class);
        userEntity.setPassword(Md5Utils.md5(userEntity.getPassword()))
                .setCreateTime(new Date())
                .setUserId(SnowFlakesUtil.nextId());
        userEntityMapper.insert(userEntity);
    }
}
