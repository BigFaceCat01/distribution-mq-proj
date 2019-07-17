package com.hxb.mq.service.impl;

import com.hxb.common.model.request.UserSaveReq;
import com.hxb.common.model.response.AllUserInfoVO;
import com.hxb.dao.entity.UserEntity;
import com.hxb.dao.mapper.UserEntityMapper;
import com.hxb.mq.exception.BusinessException;
import com.hxb.mq.service.UserService;
import com.hxb.structure.util.BeanConvertUtils;
import com.hxb.structure.util.Md5Utils;
import com.hxb.structure.util.SnowFlakesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-24 17:41:46
 */
@Service(value = "com.hxb.mq.service.UserService")
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserEntityMapper userEntityMapper;

    @Override
    public List<AllUserInfoVO> listAllUser() {
        return BeanConvertUtils.convertList(userEntityMapper.listAllUser(),AllUserInfoVO.class);
    }

    @Override
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
    }

}
