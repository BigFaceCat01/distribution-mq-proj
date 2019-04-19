package com.hxb.dao.mapper;

import com.hxb.dao.entity.OrderDetailEntity;

import java.util.List;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-18 22:26:12
 */
public interface OrderDetailEntityMapper {
    /**
     * 新增订单明细
     * @param record 明细
     * @return 影响行数
     */
    int insert(OrderDetailEntity record);

    /**
     * 批量新增订单明细
     * @param records 明细列表
     * @return 影响行数
     */
    int insertBatch(List<OrderDetailEntity> records);

    /**
     * 根据订单id查询订单明细列表
     * @param orderId 订单id
     * @return 明细列表
     */
    List<OrderDetailEntity> listByOrderId(Long orderId);
}