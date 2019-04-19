package com.hxb.dao.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-18 22:26:12
 */
@Data
public class OrderDetailEntity {
    /**
     * 明细id,无实际作用，仅用作主键
     */
    private Integer orderDetailId;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品数量
     */
    private BigDecimal productAmount;
    /**
     * 产品总价
     */
    private Long productTotalPrice;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 产品单价
     */
    private Long productPrice;
    /**
     * 产品图片
     */
    private String productImg;
}