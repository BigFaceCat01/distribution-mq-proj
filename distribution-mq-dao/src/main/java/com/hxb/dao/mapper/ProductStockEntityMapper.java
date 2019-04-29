package com.hxb.dao.mapper;

import com.hxb.dao.entity.ProductStockEntity;
import com.hxb.dao.model.ProductStockUpdateModel;

import java.util.List;

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
     * 获得所有商品库存信息
     * @return 库存列表
     */
    List<ProductStockEntity> listAllProductStock();

    /**
     * 通过产品id修改非空字段
     * @param record 产品库存信息
     * @return 影响行数
     */
    int updateByProductIdSelective(ProductStockEntity record);

    /**
     * 通过产品id和版本号修改非空字段
     * @param updateModel 产品库存信息
     * @return 影响行数
     */
    int updateByProductIdAndVersionSelective(ProductStockUpdateModel updateModel);
}