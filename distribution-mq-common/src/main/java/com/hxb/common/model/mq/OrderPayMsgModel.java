package com.hxb.common.model.mq;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty("订单号")
    private Long orderNo;
    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    private String productName;
    /**
     * 产品价格
     */
    @ApiModelProperty("产品价格(单位：分)")
    private Long totalPrice;
    /**
     * 支付时间
     */
    @ApiModelProperty("支付时间")
    private Date payTime;
    /**
     * 购买人id
     */
    @ApiModelProperty("购买人id")
    private Long buyerId;
    /**
     * 购买数量
     */
    @ApiModelProperty("购买数量")
    private BigDecimal amount;
}
