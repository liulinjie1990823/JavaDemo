USE demo;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `birthday` bigint(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `header_url` varchar(200) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `login_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户登录类型：0手机登录1微信2qq3微博',
  `password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;