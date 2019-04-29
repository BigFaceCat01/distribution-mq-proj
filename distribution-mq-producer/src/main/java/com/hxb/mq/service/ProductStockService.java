package com.hxb.mq.service;

import com.hxb.common.model.request.ProductStockSaveReq;
import com.hxb.common.model.request.ProductStockUpdateReq;
import com.hxb.common.model.response.AllProductStockVO;

import java.util.List;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-28 13:56:33
 */
public interface ProductStockService {
    /**
     * 查询所有商品库存信息
     * @return 库存列表
     */
    List<AllProductStockVO> listAllProductStock();
    /**
     * 新增一个商品库存信息
     * @param stockSaveReq 库存信息
     */
    void insert(ProductStockSaveReq stockSaveReq);

    /**
     * 修改商品库存
     * @param updateReq 修改信息
     */
    void update(ProductStockUpdateReq updateReq);

    /**
     * 秒杀商品,只是简单的进行库存判断
     * 是否库存大于0
     * @param productId 商品id
     */
    void seckill(Long productId);

    /**
     * 秒杀商品,只是简单的进行库存判断,使用synchronize关键字
     * 是否库存大于0
     * @param productId 商品id
     */
    void seckillWithSynchronized(Long productId);
    /**
     * 秒杀商品,只是简单的进行库存判断,使用数据库乐观锁
     * 是否库存大于0
     * @param productId 商品id
     */
    void seckillWithPositiveLock(Long productId);
}
