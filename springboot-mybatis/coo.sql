CREATE TABLE `coo_user` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_no` varchar(64) NOT NULL COMMENT '用户号',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `mobile_no` varchar(11) NOT NULL COMMENT '手机号',
  `address` varchar(200) NOT NULL COMMENT '住址',
  `user_status` char(1) DEFAULT '1' COMMENT '用户状态 1:正常, 0:失效',
  `crt_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `upt_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_user_no` (`user_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

