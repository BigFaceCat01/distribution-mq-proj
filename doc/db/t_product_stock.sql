CREATE TABLE `t_product_stock` (
  `product_id` bigint(20) NOT NULL COMMENT '商品id',
  `amount` decimal(10,2) NOT NULL COMMENT '商品库存数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `product_name` varchar(100) NOT NULL DEFAULT '' COMMENT '商品名称',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简单商品库存表';



INSERT INTO `t_product_stock` (`product_id`, `product_name`, `amount`, `create_time`, `modify_time`) VALUES ('279486459864416257', 'iphone xs', '10000.00', '2019-04-20 15:50:13', '0000-00-00 00:00:00');
INSERT INTO `t_product_stock` (`product_id`, `product_name`, `amount`, `create_time`, `modify_time`) VALUES ('279486459864416258', 'huawei mate10', '10000.00', '2019-04-20 15:51:01', '0000-00-00 00:00:00');
INSERT INTO `t_product_stock` (`product_id`, `product_name`, `amount`, `create_time`, `modify_time`) VALUES ('279486459868610560', 'xiaomi 9', '10000.00', '2019-04-20 15:51:12', '0000-00-00 00:00:00');
INSERT INTO `t_product_stock` (`product_id`, `product_name`, `amount`, `create_time`, `modify_time`) VALUES ('279486459868610561', 'samsung Galaxy S9', '10000.00', '2019-04-20 15:51:23', '0000-00-00 00:00:00');




