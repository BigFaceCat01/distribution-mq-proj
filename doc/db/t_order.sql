CREATE TABLE `t_order` (
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `total_amount` decimal(10,2) NOT NULL COMMENT '总数量',
  `pay_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '支付时间',
  `total_price` bigint(20) NOT NULL COMMENT '总价',
  `buyer_id` bigint(20) NOT NULL COMMENT '购买人id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `order_status` tinyint(2) NOT NULL COMMENT '订单状态 1 未支付 2 已支付 3 订单关闭',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`order_id`),
  KEY `idx_payer_id` (`buyer_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简单订单表'