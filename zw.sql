/*
Navicat MySQL Data Transfer

Source Server         : zw
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : zw

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2020-04-03 16:34:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for staffs
-- ----------------------------
DROP TABLE IF EXISTS `staffs`;
CREATE TABLE `staffs` (
  `account` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `pay` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staffs
-- ----------------------------
INSERT INTO `staffs` VALUES ('2103', '张三丰', '男', '13333333333', '23', '10800');
INSERT INTO `staffs` VALUES ('2706', '吴明凯', '男', '12222222222', '22', '10200');
INSERT INTO `staffs` VALUES ('2899', '肖玉兰', '女', '15555555555', '21', '8800');
INSERT INTO `staffs` VALUES ('2936', '花无缺', '男', '17777777777', '24', '11500');
INSERT INTO `staffs` VALUES ('3055', '陈杰斯', '男', '18888888888', '25', '10500');
INSERT INTO `staffs` VALUES ('3166', '马冬梅', '女', '19999999999', '23', '9400');
INSERT INTO `staffs` VALUES ('3487', '秋意浓', '女', '16666666666', '22', '10300');
INSERT INTO `staffs` VALUES ('3555', '武舞', '女', '11155555555', '25', '11100');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `StaffID` int(11) NOT NULL AUTO_INCREMENT,
  `Account` varchar(40) DEFAULT NULL,
  `Password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`StaffID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '123', '123');
INSERT INTO `users` VALUES ('2', '111', '111');
INSERT INTO `users` VALUES ('3', 'admin', 'admin');
INSERT INTO `users` VALUES ('4', '666', '666');
INSERT INTO `users` VALUES ('8', '222', '222');
INSERT INTO `users` VALUES ('9', '321', '321');
INSERT INTO `users` VALUES ('10', '222', '222');
INSERT INTO `users` VALUES ('11', '211', '211');
INSERT INTO `users` VALUES ('12', '777', '777');
INSERT INTO `users` VALUES ('13', 'zw', 'zw');
INSERT INTO `users` VALUES ('14', '22', '22');
INSERT INTO `users` VALUES ('15', '888', '888');
