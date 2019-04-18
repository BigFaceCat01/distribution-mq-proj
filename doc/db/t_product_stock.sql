CREATE TABLE `t_product_stock` (
  `product_id` bigint(20) NOT NULL COMMENT '商品id',
  `amount` decimal(10,2) NOT NULL COMMENT '商品库存数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简单商品库存表'