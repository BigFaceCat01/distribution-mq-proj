# 创建用户表
CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(60) NOT NULL COMMENT '用户名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  KEY `cpx_user_name_pwd` (`user_name`,`password`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简单用户表';


# 插入初始数据,密码为admin
INSERT INTO `t_user` VALUES (279486459864416256, 'admin', '2019-4-20 15:46:54', '21232f297a57a5a743894a0e4a801fc3', '0000-0-0 00:00:00');
