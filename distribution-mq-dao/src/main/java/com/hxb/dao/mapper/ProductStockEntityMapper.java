package com.hxb.dao.mapper;

import com.hxb.dao.entity.ProductStockEntity;
/**
 * @author Created by huang xiao bao
 * @date 2019-04-18 22:26:12
 */
public interface ProductStockEntityMapper {

    /**
     * 新增产品库存记录
     * @param record 库存信息
     * @return 影响行数
     */
    int insert(ProductStockEntity record);

    /**
     * 根据产品id查询产品库存信息
     * @param productId 产品id
     * @return 影响行数
     */
    ProductStockEntity queryByProductId(Long productId);

    /**
     * 通过产品id修改非空字段
     * @param record 产品库存信息
     * @return 影响行数
     */
    int updateByProductIdSelective(ProductStockEntity record);
}