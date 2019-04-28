package com.hxb.common.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-18 22:26:12
 */
@Data
public class AllProductStockVO implements Serializable {
    /**
     * 产品id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("产品id")
    private Long productId;
    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    private String productName;
    /**
     * 产品库存
     */
    @ApiModelProperty("产品库存")
    private BigDecimal amount;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date modifyTime;
}