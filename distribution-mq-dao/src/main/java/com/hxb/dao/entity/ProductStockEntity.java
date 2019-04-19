package com.hxb.dao.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @author Created by huang xiao bao
 * @date 2019-04-18 22:26:12
 */
@Data
public class ProductStockEntity {
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 产品库存
     */
    private BigDecimal amount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
}