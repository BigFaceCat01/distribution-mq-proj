package com.hxb.common.model.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author create by huang xiao bao
 * @date 2019-04-20 16:56:18
 */
@Data
public class OrderReq implements Serializable {
    /**
     * 产品总数
     */
    private BigDecimal totalAmount;
    /**
     * 订单总价
     */
    private Long totalPrice;
    /**
     * 购买人id
     */
    private Long buyerId;
    /**
     * 订单明细列表
     */
    private List<OrderDetailReq> details;
}
