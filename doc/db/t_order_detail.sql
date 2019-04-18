CREATE TABLE `t_order_detail` (
  `product_id` bigint(20) NOT NULL COMMENT '商品id',
  `product_name` varchar(200) NOT NULL COMMENT '商品名称',
  `product_amount` decimal(10,2) NOT NULL COMMENT '商品购买数量',
  `product_total_price` bigint(20) NOT NULL COMMENT '商品总价',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `product_price` bigint(20) NOT NULL COMMENT '商品单价',
  `product_img` varchar(150) NOT NULL DEFAULT '' COMMENT '商品图片路径',
  `order_detail_id` int(12) NOT NULL AUTO_INCREMENT COMMENT '明细id，仅用作主键',
  PRIMARY KEY (`order_detail_id`),
  KEY `idx_order_id` (`order_id`) USING BTREE,
  KEY `idx_product_id` (`product_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简单订单明细'