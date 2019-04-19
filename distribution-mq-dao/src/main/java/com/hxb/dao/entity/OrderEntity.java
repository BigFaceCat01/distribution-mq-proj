package com.hxb.dao.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @author Created by huang xiao bao
 * @date 2019-04-18 22:26:12
 */
@Data
public class OrderEntity {
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 产品总数
     */
    private BigDecimal totalAmount;
    /**
     * 支付时间
     */
    private Date payTime;
    /**
     * 订单总价
     */
    private Long totalPrice;
    /**
     * 购买人id
     */
    private Long buyerId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 订单状态 1 未支付 2 已支付 3 订单关闭
     */
    private Byte orderStatus;
    /**
     * 修改时间
     */
    private Date modifyTime;
}