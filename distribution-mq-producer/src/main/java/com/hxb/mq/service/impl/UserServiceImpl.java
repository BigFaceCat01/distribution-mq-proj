package com.hxb.mq.service.impl;

import com.hxb.dao.mapper.UserEntityMapper;
import com.hxb.mq.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-24 17:41:46
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserEntityMapper userEntityMapper;


}
