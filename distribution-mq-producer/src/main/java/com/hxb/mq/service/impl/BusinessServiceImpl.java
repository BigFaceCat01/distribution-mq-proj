package com.hxb.mq.service.impl;

import com.hxb.common.model.request.OrderReq;
import com.hxb.dao.entity.OrderDetailEntity;
import com.hxb.dao.entity.OrderEntity;
import com.hxb.mq.service.BusinessService;
import com.hxb.structure.util.BeanConvertUtils;
import com.yma.rpc.core.provider.annotation.Rpc;
import org.springframework.stereotype.Service;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-17 11:36:02
 */
@Rpc
public class BusinessServiceImpl implements BusinessService {

    @Override
    public void insertOrder(OrderReq orderReq) {
        OrderEntity orderEntity = buildOrder(orderReq);
        OrderDetailEntity orderDetailEntity = buildOrderDetail(orderReq);
    }

    private OrderEntity buildOrder(OrderReq orderReq){
        OrderEntity orderEntity = BeanConvertUtils.convert(orderReq, OrderEntity.class);
        return orderEntity;
    }

    private OrderDetailEntity buildOrderDetail(OrderReq orderReq){
//        OrderDetailEntity orderDetailEntity = BeanConvertUtils.convertList(orderReq.getDetails(), OrderDetailEntity.class);
//        return orderDetailEntity;
        return null;
    }
}
