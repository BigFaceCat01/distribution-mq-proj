package com.hxb.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author create by huang xiao bao
 * @date 2019-04-29 17:41:40
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductStockUpdateModel implements Serializable {
    /**
     * 产品id
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
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 版本号
     */
    private Integer productStockVersion;
    /**
     * 原来版本号
     */
    private Integer oldProductStockVersion;
}
