CREATE TABLE `coo_user` (
    `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_no` VARCHAR (64) NOT NULL COMMENT '用户号',
    `user_name` VARCHAR (64) NOT NULL COMMENT '用户姓名',
    `password` VARCHAR (8) NOT NULL COMMENT '密码',
    `mobile_no` VARCHAR (11) NOT NULL COMMENT '手机号',
    `address` VARCHAR (512) DEFAULT '' COMMENT '住址',
    `user_status` CHAR (1) NOT NULL DEFAULT '1' COMMENT '用户状态 1:有效,0:无效',
    `crt_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `upt_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_user_no` (`user_no`),
    UNIQUE KEY `idx_mobile_no` (`mobile_no`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;