package com.hxb.dao.mapper;

import com.hxb.dao.entity.OrderEntity;
/**
 * @author Created by huang xiao bao
 * @date 2019-04-18 22:26:12
 */
public interface OrderEntityMapper {
    /**
     * 新增订单
     * @param record 订单信息
     * @return 影响行数
     */
    int insert(OrderEntity record);

    /**
     * 根据订单id查询订单信息
     * @param orderId 订单id
     * @return 订单信息
     */
    OrderEntity queryByOrderId(Long orderId);

    /**
     * 通过订单id修改非空字段
     * @param record 修改信息
     * @return 影响行数
     */
    int updateByOrderIdSelective(OrderEntity record);

}