/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : myblog

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2021-01-10 14:10:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bloger` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `images` varchar(255) DEFAULT NULL,
  `goodNum` int(11) NOT NULL,
  `subTime` datetime NOT NULL,
  `isTop` int(1) NOT NULL DEFAULT '0',
  `isGood` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('33', '1', '心田上的百合花', '在一个偏僻遥远的山谷里，有一个高达数千尺的断崖。 不知道什么时候，断崖边上长出了-株小小的百合。\n一开始百合刚刚诞生的时候，长得和杂草-模-样。但是，它心里知道自己并不是一株野草。 它的内心深\n处，有一个内在的纯洁的念头:“我是一株百合， 不是-株野草。惟-能证明我是百合的方法，就是开出美丽的\n花朵。\n', 'img/mxd190125-photo-1610035946792.png#img/mxd190125-photo-1610012207452.png', '12', '2021-01-09 16:15:37', '1', '1');
INSERT INTO `blog` VALUES ('34', '1', '夜雨诗意', '早年为了学写古诗，曾买过-部线装本的《诗韵合壁》，一函共6册， 字体很小，内容很多。除了供查诗韵\n外,它还把各种物象、各种情景、各种心绪分门别类，纂集历代相关诗句，成了一部颇为齐全的诗歌词典。 过去\n文人要应急写诗时，查一直，套-套，很可快速地炮制出几首来。但是毫无疑问，这样写出来的诗都是不值一读\n的。只有在不带写诗任务时随便翻翻，看看在同一名目下中国诗化语词的多方汇集，才有一点意思。\n', 'img/mxd190125-photo-1610035946792.png#img/mxd190125-image-1610091722889.png', '10', '2021-01-09 21:23:31', '0', '1');
INSERT INTO `blog` VALUES ('35', '1', '在秋天里拾起青春的落叶\n', '一个人的旅程从来都会给人以孤独感。 当列车北上的时候，车轮与钢轨接缝处碰撞的声音枯燥地敲在我心头\n上，在昏暗寂静的车厢里便弥漫着那种孤独的情绪。月光下幽暗的铁轨静静地躺卧于大地，铁轨遥远的那端会是\n人生的尽头吗?\n', 'img/mxd190125-photo-1610035946792.png#img/mxd190125-image-1610091722889.png', '4', '2021-01-09 22:23:32', '0', '0');

-- ----------------------------
-- Table structure for discuss
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `blogId` int(11) NOT NULL,
  `discusser` int(11) NOT NULL,
  `subTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discuss
-- ----------------------------
INSERT INTO `discuss` VALUES ('1', '你写的太好啦！！！', '1', '1', '2021-01-06 22:04:48');
INSERT INTO `discuss` VALUES ('2', '真棒！', '1', '2', '2021-01-08 17:07:35');
INSERT INTO `discuss` VALUES ('5', '111', '10', '1', '2021-01-08 22:32:27');
INSERT INTO `discuss` VALUES ('6', '终于测试成功了！哈哈哈哈哈', '10', '1', '2021-01-08 22:32:54');
INSERT INTO `discuss` VALUES ('7', '我再来测试一遍', '9', '1', '2021-01-08 22:33:20');
INSERT INTO `discuss` VALUES ('8', 'daysBetween', '8', '1', '2021-01-08 22:34:00');
INSERT INTO `discuss` VALUES ('10', '2222', '10', '1', '2021-01-08 22:34:18');
INSERT INTO `discuss` VALUES ('11', '333', '10', '1', '2021-01-08 22:34:33');
INSERT INTO `discuss` VALUES ('12', '看看名字测试的怎么样。。。', '10', '1', '2021-01-08 22:37:06');
INSERT INTO `discuss` VALUES ('13', '看看名字测试的怎么样。。。', '10', '1', '2021-01-08 22:38:02');
INSERT INTO `discuss` VALUES ('14', '1', '9', '1', '2021-01-08 22:38:11');
INSERT INTO `discuss` VALUES ('15', '我马雪冬来评论一下。。。', '10', '2', '2021-01-08 22:39:48');
INSERT INTO `discuss` VALUES ('16', '我马雪冬来评论一下。。。,,,,', '9', '2', '2021-01-08 22:39:57');
INSERT INTO `discuss` VALUES ('17', '', '8', '3', '2021-01-08 22:42:16');
INSERT INTO `discuss` VALUES ('18', '我来了，我是魏希！！！！', '3', '3', '2021-01-08 22:42:50');
INSERT INTO `discuss` VALUES ('19', '55555', '10', '2', '2021-01-09 12:09:02');
INSERT INTO `discuss` VALUES ('20', 'xx', '1', '1', '2021-01-09 12:36:17');
INSERT INTO `discuss` VALUES ('24', '55555', '33', '1', '2021-01-09 17:31:35');
INSERT INTO `discuss` VALUES ('25', '我是mxd190125', '33', '1', '2021-01-09 17:31:42');
INSERT INTO `discuss` VALUES ('26', '5555555', '35', '1', '2021-01-10 12:20:54');
INSERT INTO `discuss` VALUES ('27', '我是马雪冬。。。。', '34', '1', '2021-01-10 12:21:00');
INSERT INTO `discuss` VALUES ('28', '不啦啦啦啦绿绿绿绿绿绿', '34', '1', '2021-01-10 12:38:08');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `passWord` varchar(255) NOT NULL,
  `registerTime` datetime NOT NULL,
  `role` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `photoUrl` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'mxd190125', '1111', '2021-01-06 22:51:29', 'user', '2860850965@qq.com', 'img/mxd190125-photo-1610208600493.png');
INSERT INTO `user` VALUES ('2', '马雪冬', '1111', '2020-12-16 23:11:01', 'user', '2860850965@qq.com', 'static/images/icon/default-head.png');
INSERT INTO `user` VALUES ('3', '魏希', '1111', '2021-01-07 00:22:23', 'user', '2860850965@qq.com', 'static/images/icon/default-head.png');
INSERT INTO `user` VALUES ('4', 'mxd', '1111', '2021-01-07 00:34:27', 'user', '2860850965@qq.com', 'static/images/icon/default-head.png');
INSERT INTO `user` VALUES ('5', '马雪冬1', '1111', '2021-01-09 12:36:16', 'admin', '2860850965@qq.com', 'static/images/icon/default-head.png');
INSERT INTO `user` VALUES ('7', 'hyl', '1111', '2021-01-10 14:08:02', 'user', '2860850965@qq.com', 'static/images/icon/default-head.png');
