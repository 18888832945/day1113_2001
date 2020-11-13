/*
Navicat MySQL Data Transfer

Source Server         : 1906JavaA
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : day1104

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2020-11-05 11:30:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_exam`
-- ----------------------------
DROP TABLE IF EXISTS `tb_exam`;
CREATE TABLE `tb_exam` (
  `examid` bigint(20) NOT NULL AUTO_INCREMENT,
  `ename` varchar(255) DEFAULT NULL,
  `etype` varchar(255) DEFAULT NULL,
  `efenzhi` double DEFAULT NULL,
  `testid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`examid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_exam
-- ----------------------------
INSERT INTO `tb_exam` VALUES ('1', '奥巴马当了几届美国总统', '单选题', '5', '1');
INSERT INTO `tb_exam` VALUES ('2', '特朗普能连任吗', '判断题', '5', '1');
INSERT INTO `tb_exam` VALUES ('3', 'Java的三特征', '多选题', '5', '1');

-- ----------------------------
-- Table structure for `tb_examoption`
-- ----------------------------
DROP TABLE IF EXISTS `tb_examoption`;
CREATE TABLE `tb_examoption` (
  `optionid` bigint(20) NOT NULL AUTO_INCREMENT,
  `oname` varchar(255) DEFAULT NULL,
  `istrue` int(11) DEFAULT NULL,
  `examid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`optionid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_examoption
-- ----------------------------
INSERT INTO `tb_examoption` VALUES ('1', '1届', '0', '1');
INSERT INTO `tb_examoption` VALUES ('2', '2届', '1', '1');
INSERT INTO `tb_examoption` VALUES ('3', '3届', '0', '1');
INSERT INTO `tb_examoption` VALUES ('4', '4届', '0', '1');
INSERT INTO `tb_examoption` VALUES ('5', '不能', '1', '2');
INSERT INTO `tb_examoption` VALUES ('6', '能', '0', '2');
INSERT INTO `tb_examoption` VALUES ('7', '封装', '1', '3');
INSERT INTO `tb_examoption` VALUES ('8', '继承', '1', '3');
INSERT INTO `tb_examoption` VALUES ('9', '多态', '1', '3');
INSERT INTO `tb_examoption` VALUES ('10', '抽象', '0', '3');

-- ----------------------------
-- Table structure for `tb_grade`
-- ----------------------------
DROP TABLE IF EXISTS `tb_grade`;
CREATE TABLE `tb_grade` (
  `gid` bigint(20) NOT NULL AUTO_INCREMENT,
  `gname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_grade
-- ----------------------------
INSERT INTO `tb_grade` VALUES ('1', '2001JavaA');
INSERT INTO `tb_grade` VALUES ('2', '2001PhpA');
INSERT INTO `tb_grade` VALUES ('3', '1911JavaA');
INSERT INTO `tb_grade` VALUES ('4', '1908JavaA');
INSERT INTO `tb_grade` VALUES ('5', '2006JavaA');

-- ----------------------------
-- Table structure for `tb_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `mid` bigint(20) NOT NULL AUTO_INCREMENT,
  `mname` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('1', '学成在线教育管理系统', null, 'rightFrame', null, '0');
INSERT INTO `tb_menu` VALUES ('2', '教务管理', null, 'rightFrame', null, '1');
INSERT INTO `tb_menu` VALUES ('3', '学生考试系统', null, 'rightFrame', '/csstree/img/diy/5.png', '1');
INSERT INTO `tb_menu` VALUES ('4', '独立考试', null, 'rightFrame', null, '3');
INSERT INTO `tb_menu` VALUES ('5', '题库管理', null, 'rightFrame', null, '3');
INSERT INTO `tb_menu` VALUES ('6', '阅卷管理', null, 'rightFrame', null, '3');
INSERT INTO `tb_menu` VALUES ('7', '我的考试', null, 'rightFrame', null, '3');
INSERT INTO `tb_menu` VALUES ('8', '历史试卷', null, 'rightFrame', null, '3');
INSERT INTO `tb_menu` VALUES ('9', '总分积分管理系统', null, 'rightFrame', null, '1');
INSERT INTO `tb_menu` VALUES ('10', '考勤系统', null, 'rightFrame', null, '1');

-- ----------------------------
-- Table structure for `tb_student`
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `sid` bigint(20) NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) DEFAULT NULL,
  `saccount` varchar(255) DEFAULT NULL,
  `spwd` varchar(255) DEFAULT NULL,
  `idcard` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES ('1', '赵一伤', null, null, null);
INSERT INTO `tb_student` VALUES ('2', '田二败', null, null, null);
INSERT INTO `tb_student` VALUES ('3', '孙三毁', null, null, null);
INSERT INTO `tb_student` VALUES ('4', '张三丰', null, null, null);
INSERT INTO `tb_student` VALUES ('5', '宋远桥', null, null, null);
INSERT INTO `tb_student` VALUES ('6', '俞莲舟', null, null, null);
INSERT INTO `tb_student` VALUES ('7', '俞岱岩', null, null, null);
INSERT INTO `tb_student` VALUES ('8', '张松溪', null, null, null);
INSERT INTO `tb_student` VALUES ('9', '张翠山', null, null, null);
INSERT INTO `tb_student` VALUES ('10', '尹丽萍', null, null, null);
INSERT INTO `tb_student` VALUES ('11', '莫声谷', null, null, null);

-- ----------------------------
-- Table structure for `tb_student_grade`
-- ----------------------------
DROP TABLE IF EXISTS `tb_student_grade`;
CREATE TABLE `tb_student_grade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sid` bigint(20) DEFAULT NULL,
  `gid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_student_grade
-- ----------------------------
INSERT INTO `tb_student_grade` VALUES ('1', '1', '1');
INSERT INTO `tb_student_grade` VALUES ('2', '2', '1');
INSERT INTO `tb_student_grade` VALUES ('3', '3', '2');
INSERT INTO `tb_student_grade` VALUES ('4', '4', '2');
INSERT INTO `tb_student_grade` VALUES ('5', '5', '2');
INSERT INTO `tb_student_grade` VALUES ('6', '6', '3');
INSERT INTO `tb_student_grade` VALUES ('7', '7', '5');
INSERT INTO `tb_student_grade` VALUES ('8', '8', '5');
INSERT INTO `tb_student_grade` VALUES ('9', '9', '5');
INSERT INTO `tb_student_grade` VALUES ('10', '10', '5');

-- ----------------------------
-- Table structure for `tb_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT,
  `tname` varchar(255) DEFAULT NULL,
  `taccount` varchar(255) DEFAULT NULL,
  `telphone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES ('1', '李增强', 'lizq', '18888832945', '362608691@qq.com', 'lizq');
INSERT INTO `tb_teacher` VALUES ('2', '毛飞川', 'maofc', '13588888888', '123@qq.com', 'maofc');

-- ----------------------------
-- Table structure for `tb_teacher_grade`
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher_grade`;
CREATE TABLE `tb_teacher_grade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tid` bigint(20) DEFAULT NULL,
  `gid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_teacher_grade
-- ----------------------------
INSERT INTO `tb_teacher_grade` VALUES ('1', '1', '1');
INSERT INTO `tb_teacher_grade` VALUES ('2', '1', '2');
INSERT INTO `tb_teacher_grade` VALUES ('3', '1', '3');
INSERT INTO `tb_teacher_grade` VALUES ('4', '1', '4');
INSERT INTO `tb_teacher_grade` VALUES ('5', '1', '5');
INSERT INTO `tb_teacher_grade` VALUES ('6', '2', '5');

-- ----------------------------
-- Table structure for `tb_test`
-- ----------------------------
DROP TABLE IF EXISTS `tb_test`;
CREATE TABLE `tb_test` (
  `testid` bigint(20) NOT NULL AUTO_INCREMENT,
  `testname` varchar(255) DEFAULT NULL,
  `totalscore` double DEFAULT NULL,
  `passscore` double DEFAULT NULL,
  `testtime` int(11) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `testauthor` varchar(255) DEFAULT NULL,
  `authorid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`testid`),
  UNIQUE KEY `testname_uq` (`testname`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_test
-- ----------------------------
INSERT INTO `tb_test` VALUES ('1', '2001JavaA日考1105', '100', '60', '30', '2020-11-05 13:30:00', '2020-11-05 14:00:00', '2020-11-05 10:24:51', '李增强', '1');

-- ----------------------------
-- Table structure for `tb_test_grade`
-- ----------------------------
DROP TABLE IF EXISTS `tb_test_grade`;
CREATE TABLE `tb_test_grade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gid` bigint(20) DEFAULT NULL,
  `testid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_test_grade
-- ----------------------------
INSERT INTO `tb_test_grade` VALUES ('1', '1', '1');
INSERT INTO `tb_test_grade` VALUES ('2', '2', '1');
INSERT INTO `tb_test_grade` VALUES ('3', '3', '1');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '赵一伤', '111', '18');
INSERT INTO `tb_user` VALUES ('2', '田二败', '222', '19');
INSERT INTO `tb_user` VALUES ('3', '孙三毁', null, null);
INSERT INTO `tb_user` VALUES ('4', '李四摧', null, null);
INSERT INTO `tb_user` VALUES ('5', '吴五伦', null, null);
INSERT INTO `tb_user` VALUES ('6', '周六破', null, '26');
INSERT INTO `tb_user` VALUES ('7', '郑七灭', null, null);
INSERT INTO `tb_user` VALUES ('8', '王八衰', null, null);
