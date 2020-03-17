/*
Navicat MySQL Data Transfer

Source Server         : Test
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : carts

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-06-14 09:12:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for carts
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts` (
  `id` int(111) DEFAULT NULL COMMENT '商品编号',
  `productid` int(111) NOT NULL AUTO_INCREMENT COMMENT '购物车商品编号',
  `count` int(111) DEFAULT NULL COMMENT '商品数量',
  `userid` int(11) DEFAULT NULL COMMENT '顾客ID',
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carts
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `price` int(100) DEFAULT NULL COMMENT '商品价值',
  `type` varchar(255) DEFAULT NULL COMMENT '商品类型',
  `stock` int(255) DEFAULT NULL COMMENT '商品库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '可口可乐', '3', '饮料', '3');
INSERT INTO `goods` VALUES ('2', '安佳牛奶', '10', '饮料', '10');
INSERT INTO `goods` VALUES ('3', '锤子手机', '2399', '数码', '3');
INSERT INTO `goods` VALUES ('4', '雪碧', '2', '饮料', '10');
INSERT INTO `goods` VALUES ('5', '红薯', '1', '食品', '3');
INSERT INTO `goods` VALUES ('6', '面包', '2', '食品', '3');
INSERT INTO `goods` VALUES ('7', '面条', '5', '食品', '10');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(111) NOT NULL COMMENT '顾客会员卡号',
  `uname` varchar(255) DEFAULT NULL COMMENT '顾客姓名',
  `id` varchar(255) DEFAULT NULL COMMENT '身份证号x用0替代',
  `birthday` date DEFAULT NULL COMMENT '生日,可以从身份证获取',
  `address` varchar(255) DEFAULT NULL COMMENT '会员地址',
  `tel` varchar(255) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小鸣', '610113198712310435', '2017-06-04', '', '1868182123');
INSERT INTO `user` VALUES ('1231', '测试人', '610113199712110315', '1997-12-11', 'MySql数据库', '13475663218');
