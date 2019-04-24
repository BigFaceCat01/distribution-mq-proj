package com.hxb.common.model.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author create by huang xiao bao
 * @date 2019-04-20 16:58:37
 */
@Data
public class OrderDetailReq implements Serializable {
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 产品数量
     */
    private BigDecimal productAmount;
    /**
     * 产品总价
     */
    private Long productTotalPrice;
    /**
     * 产品单价
     */
    private Long productPrice;
    /**
     * 产品图片
     */
    private String productImg;
}
