package com.hxb.dao.mapper;

import com.hxb.dao.entity.OrderEntity;

public interface OrderEntityMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(OrderEntity record);

    int insertSelective(OrderEntity record);

    OrderEntity selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(OrderEntity record);

    int updateByPrimaryKey(OrderEntity record);
}