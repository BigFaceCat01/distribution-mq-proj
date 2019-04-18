package com.hxb.dao.mapper;

import com.hxb.dao.entity.OrderDetailEntity;

public interface OrderDetailEntityMapper {
    int deleteByPrimaryKey(Integer orderDetailId);

    int insert(OrderDetailEntity record);

    int insertSelective(OrderDetailEntity record);

    OrderDetailEntity selectByPrimaryKey(Integer orderDetailId);

    int updateByPrimaryKeySelective(OrderDetailEntity record);

    int updateByPrimaryKey(OrderDetailEntity record);
}