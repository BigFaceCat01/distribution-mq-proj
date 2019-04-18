CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(60) NOT NULL COMMENT '用户名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  KEY `cpx_user_name_pwd` (`user_name`,`password`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简单用户表'