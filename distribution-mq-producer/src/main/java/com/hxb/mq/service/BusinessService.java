package com.hxb.mq.service;

import com.hxb.common.model.request.OrderReq;
import com.yma.rpc.core.invoker.annotation.RpcApi;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-17 11:35:46
 */
public interface BusinessService {
    /**
     * 新增一个订单
     * @param orderReq 订单信息
     */
    void insertOrder(OrderReq orderReq);
}
