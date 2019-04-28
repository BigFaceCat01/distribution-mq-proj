package com.hxb.common.model.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-18 22:26:12
 */
@Data
@Builder
public class ProductStockUpdateReq {
    /**
     * 商品id
     */
    private Long productId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品库存
     */
    private BigDecimal amount;
}