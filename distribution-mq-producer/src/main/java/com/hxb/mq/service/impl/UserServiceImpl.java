package com.hxb.mq.service.impl;

import com.hxb.common.model.request.UserSaveReq;
import com.hxb.common.model.response.AllUserInfoVO;
import com.hxb.common.model.response.CacheResult;
import com.hxb.dao.entity.UserEntity;
import com.hxb.dao.mapper.UserEntityMapper;
import com.hxb.mq.aop.ParamLog;
import com.hxb.mq.constants.UserConstants;
import com.hxb.mq.exception.BusinessException;
import com.hxb.mq.service.CacheClient;
import com.hxb.mq.service.UserService;
import com.hxb.structure.util.BeanConvertUtils;
import com.hxb.structure.util.Md5Utils;
import com.hxb.structure.util.SnowFlakesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-24 17:41:46
 */
@Service(value = "com.hxb.mq.service.UserService")
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserEntityMapper userEntityMapper;
    @Autowired
    private CacheClient cacheClient;

    @Override
    public List<AllUserInfoVO> listAllUser() {
        return BeanConvertUtils.convertList(userEntityMapper.listAllUser(),AllUserInfoVO.class);
    }

    @Override
    @ParamLog
    @Transactional(rollbackFor = Exception.class)
    public void insertUser(UserSaveReq saveReq){
        boolean contain = userEntityMapper.queryByUserName(saveReq.getUserName());
        if(contain){
            throw new BusinessException("repeat user name !!!",saveReq.getUserName());
        }
        UserEntity userEntity = BeanConvertUtils.convert(saveReq, UserEntity.class);
        userEntity.setPassword(Md5Utils.md5(userEntity.getPassword()))
                .setCreateTime(new Date())
                .setUserId(SnowFlakesUtil.nextId());
        userEntityMapper.insert(userEntity);
        int  i = 1/0;
    }

    @Override
    @ParamLog
    public void insertUserWithRedis(UserSaveReq saveReq) {
        String key = UserConstants.USER_REGISTER_PREFIX + saveReq.getUserName();
        CacheResult cacheResult = cacheClient.setIfAbsent(key, key,TimeUnit.SECONDS,3);
        if(!cacheResult.getSuccess()){
            //调用redis失败
            throw new BusinessException("please try it after three seconds");
        }
        if(!cacheResult.getData(Boolean.class)){
            //已经有人在进行该用户名的添加
            throw new BusinessException("click quickly!!!");
        }
        insertUser(saveReq);
    }
}
