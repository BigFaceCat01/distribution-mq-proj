package com.hxb.common.model.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-18 22:26:12
 */
@Data
public class ProductStockSaveReq {
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品库存
     */
    private BigDecimal amount;
}