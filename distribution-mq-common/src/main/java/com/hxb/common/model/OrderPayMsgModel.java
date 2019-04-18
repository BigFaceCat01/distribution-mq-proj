package com.hxb.common.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-18 10:48:27
 */
@Data
public class OrderPayMsgModel implements Serializable {
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品价格
     */
    private Long totalPrice;
    /**
     * 支付时间
     */
    private Date payTime;
    /**
     * 购买人id
     */
    private Long buyerId;
    /**
     * 购买数量
     */
    private BigDecimal amount;
}
