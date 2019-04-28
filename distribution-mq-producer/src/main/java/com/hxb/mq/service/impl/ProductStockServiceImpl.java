package com.hxb.mq.service.impl;

import com.hxb.common.model.request.ProductStockSaveReq;
import com.hxb.common.model.request.ProductStockUpdateReq;
import com.hxb.common.model.response.AllProductStockVO;
import com.hxb.dao.entity.ProductStockEntity;
import com.hxb.dao.mapper.ProductStockEntityMapper;
import com.hxb.mq.aop.ParamLog;
import com.hxb.mq.exception.BusinessException;
import com.hxb.mq.service.ProductStockService;
import com.hxb.structure.util.BeanConvertUtils;
import com.hxb.structure.util.SnowFlakesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-28 14:05:21
 */
@Service
@Slf4j
public class ProductStockServiceImpl implements ProductStockService {
    @Resource
    private ProductStockEntityMapper productStockEntityMapper;


    @Override
    public List<AllProductStockVO> listAllProductStock() {
        return BeanConvertUtils.convertList(productStockEntityMapper.listAllProductStock(),AllProductStockVO.class);
    }

    @Override
    @ParamLog
    public void insert(ProductStockSaveReq stockSaveReq) {
        ProductStockEntity stockEntity = BeanConvertUtils.convert(stockSaveReq, ProductStockEntity.class);
        stockEntity.setCreateTime(new Date())
                .setProductId(SnowFlakesUtil.nextId());
        productStockEntityMapper.insert(stockEntity);
    }

    @Override
    @ParamLog
    public void update(ProductStockUpdateReq updateReq) {
        ProductStockEntity stockEntity = BeanConvertUtils.convert(updateReq, ProductStockEntity.class);
        stockEntity.setModifyTime(new Date());
        productStockEntityMapper.updateByProductIdSelective(stockEntity);
    }

    @Override
    @ParamLog
    public void seckill(Long productId) {
        ProductStockEntity oldEntity = productStockEntityMapper.queryByProductId(productId);
        //0大于库存不抛异常，小于等于都应该抛出异常
        if(BigDecimal.ZERO.compareTo(oldEntity.getAmount()) != -1 ){
            log.info("{} sold out",productId);
            throw new BusinessException("this product has been sold out");
        }
        ProductStockEntity stockEntity = ProductStockEntity.builder().amount(oldEntity.getAmount().subtract(BigDecimal.ONE))
                .modifyTime(new Date())
                .productId(productId)
                .build();
        productStockEntityMapper.updateByProductIdSelective(stockEntity);
    }
}
