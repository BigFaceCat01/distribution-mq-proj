package com.hxb.dao.mapper;

import com.hxb.dao.entity.ProductStockEntity;

public interface ProductStockEntityMapper {
    int deleteByPrimaryKey(Long productId);

    int insert(ProductStockEntity record);

    int insertSelective(ProductStockEntity record);

    ProductStockEntity selectByPrimaryKey(Long productId);

    int updateByPrimaryKeySelective(ProductStockEntity record);

    int updateByPrimaryKey(ProductStockEntity record);
}