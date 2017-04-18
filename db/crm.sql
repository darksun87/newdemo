/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-04-17 18:49:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for autocode
-- ----------------------------
DROP TABLE IF EXISTS `autocode`;
CREATE TABLE `autocode` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `password` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态',
  `is_delated` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of autocode
-- ----------------------------
INSERT INTO `autocode` VALUES ('2', 'test1', '123', '1488187377758', '1488271699454', '1', '1', null, '1');
INSERT INTO `autocode` VALUES ('3', null, null, '1488351818706', '1488351818706', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('4', null, null, '1488351832946', '1488351832946', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('5', null, null, '1488351835786', '1488351835786', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('6', null, null, '1488351838354', '1488351838354', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('7', null, null, '1488351840680', '1488351840680', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('8', null, null, '1488351843216', '1488351843216', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('9', null, null, '1488351845515', '1488351845515', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('10', null, null, '1488351847640', '1488351847640', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('11', null, null, '1488351849812', '1488351849812', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('12', null, null, '1488351853853', '1488351853853', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('13', null, null, '1488351856635', '1488351856635', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('14', null, null, '1488351858809', '1488351858809', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('15', null, null, '1488351863568', '1488351863568', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('16', null, null, '1488351867561', '1488351867561', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('17', null, null, '1488351870084', '1488351870084', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('18', null, null, '1488351874098', '1488351874098', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('19', null, null, '1488351876474', '1488351876474', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('20', null, null, '1488351878752', '1488351878752', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('21', null, null, '1488351881335', '1488351881335', '1', '1', null, null);
INSERT INTO `autocode` VALUES ('22', null, null, '1488351884044', '1488351884044', '1', '1', null, null);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `attribute` varchar(255) DEFAULT NULL,
  `pid` int(10) NOT NULL,
  `rank` int(10) NOT NULL,
  `level` int(10) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '系统', null, null, '0', '5', '1', null);
INSERT INTO `resource` VALUES ('2', '用户管理', null, null, '1', '1', '2', 'user/index.html');
INSERT INTO `resource` VALUES ('3', '角色管理', null, null, '1', '2', '2', 'role/index.html');
INSERT INTO `resource` VALUES ('4', '档案管理', null, null, '0', '4', '1', 'file/index.html');
INSERT INTO `resource` VALUES ('5', '用印管理', null, null, '0', '1', '1', '');
INSERT INTO `resource` VALUES ('6', '证照管理', null, null, '0', '2', '1', '');
INSERT INTO `resource` VALUES ('7', '差旅管理', null, null, '0', '3', '1', 'travel/index.html');
INSERT INTO `resource` VALUES ('8', '印章管理', null, null, '5', '1', '2', 'signet/index.html');
INSERT INTO `resource` VALUES ('26', '用印申请', null, null, '5', '2', '2', 'signetApply/index.html');
INSERT INTO `resource` VALUES ('27', '证照管理', null, null, '6', '1', '2', 'certificate/index.html');
INSERT INTO `resource` VALUES ('28', '用证申请', null, null, '6', '2', '2', 'certificateApply/index.html');

-- ----------------------------
-- Table structure for t_certificate
-- ----------------------------
DROP TABLE IF EXISTS `t_certificate`;
CREATE TABLE `t_certificate` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `certificatename` varchar(100) DEFAULT NULL COMMENT '证照名称',
  `scanfile` bigint(20) DEFAULT NULL COMMENT '扫描件',
  `checktime` bigint(20) DEFAULT NULL COMMENT '年检到期时间',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='证照管理';

-- ----------------------------
-- Records of t_certificate
-- ----------------------------
INSERT INTO `t_certificate` VALUES ('1', '1', '1', '1', '1492419040588', '1492419040588', '1', '1', null, null);

-- ----------------------------
-- Table structure for t_certificate_apply
-- ----------------------------
DROP TABLE IF EXISTS `t_certificate_apply`;
CREATE TABLE `t_certificate_apply` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `applyreason` varchar(100) DEFAULT NULL COMMENT '申请理由',
  `certificateid` bigint(20) NOT NULL COMMENT '证照ID',
  `gm_time` bigint(20) DEFAULT NULL COMMENT '总经理审批时间',
  `gm_result` varchar(10) DEFAULT NULL COMMENT '总经理审批结果',
  `gm_suggest` varchar(100) DEFAULT NULL COMMENT '总经理审批意见',
  `revert_time` bigint(20) DEFAULT NULL COMMENT '归还时间',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='证照申请';

-- ----------------------------
-- Records of t_certificate_apply
-- ----------------------------

-- ----------------------------
-- Table structure for t_certificate_print
-- ----------------------------
DROP TABLE IF EXISTS `t_certificate_print`;
CREATE TABLE `t_certificate_print` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `printreason` varchar(100) DEFAULT NULL COMMENT '打印理由',
  `certificateid` bigint(20) NOT NULL COMMENT '证照ID',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='打印记录';

-- ----------------------------
-- Records of t_certificate_print
-- ----------------------------

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `departmentname` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';

-- ----------------------------
-- Records of t_department
-- ----------------------------

-- ----------------------------
-- Table structure for t_file
-- ----------------------------
DROP TABLE IF EXISTS `t_file`;
CREATE TABLE `t_file` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `file_type_id` bigint(20) NOT NULL COMMENT '档案类型',
  `filename` varchar(100) DEFAULT NULL COMMENT '档案名称',
  `filedesc` varchar(100) DEFAULT NULL COMMENT '档案描述',
  `attachment` longtext COMMENT '附件 ',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='档案管理';

-- ----------------------------
-- Records of t_file
-- ----------------------------

-- ----------------------------
-- Table structure for t_file_role
-- ----------------------------
DROP TABLE IF EXISTS `t_file_role`;
CREATE TABLE `t_file_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `file_id` bigint(20) NOT NULL COMMENT '档案',
  `roleid` bigint(20) NOT NULL COMMENT '角色',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='档案权限';

-- ----------------------------
-- Records of t_file_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_file_type
-- ----------------------------
DROP TABLE IF EXISTS `t_file_type`;
CREATE TABLE `t_file_type` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `typename` varchar(100) DEFAULT NULL COMMENT '档案类型',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='档案类型';

-- ----------------------------
-- Records of t_file_type
-- ----------------------------

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `module` varchar(100) DEFAULT NULL COMMENT '操作模块',
  `logcontent` varchar(255) DEFAULT NULL COMMENT '操作内容',
  `result` varchar(100) DEFAULT NULL COMMENT '操作结果',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志管理';

-- ----------------------------
-- Records of t_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `rolename` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色管理';

-- ----------------------------
-- Records of t_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `roleid` bigint(20) DEFAULT NULL COMMENT '角色',
  `url` varchar(100) DEFAULT NULL COMMENT '权限',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限管理';

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for t_signet
-- ----------------------------
DROP TABLE IF EXISTS `t_signet`;
CREATE TABLE `t_signet` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `signetname` varchar(100) DEFAULT NULL COMMENT '印章名称',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='印章管理';

-- ----------------------------
-- Records of t_signet
-- ----------------------------
INSERT INTO `t_signet` VALUES ('2', '合同章', '1492420730129', '1492421354959', '1', '1', null, '1');
INSERT INTO `t_signet` VALUES ('3', '法人章', '1492420749462', '1492421372296', '1', '1', null, '1');
INSERT INTO `t_signet` VALUES ('4', '合同章', '1492421069397', '1492421870110', '1', '1', null, null);

-- ----------------------------
-- Table structure for t_signet_apply
-- ----------------------------
DROP TABLE IF EXISTS `t_signet_apply`;
CREATE TABLE `t_signet_apply` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `applyreason` varchar(100) DEFAULT NULL COMMENT '申请理由',
  `signetid` bigint(20) NOT NULL COMMENT '印章',
  `dgm_time` bigint(20) DEFAULT NULL COMMENT '副总经理审批时间',
  `dgm_result` varchar(10) DEFAULT NULL COMMENT '副总经理审批结果',
  `dgm_suggest` varchar(100) DEFAULT NULL COMMENT '副总经理意见',
  `gm_time` bigint(20) DEFAULT NULL COMMENT '总经理审批时间',
  `gm_result` varchar(10) DEFAULT NULL COMMENT '总经理审批结果',
  `gm_suggest` varchar(100) DEFAULT NULL COMMENT '总经理审批意见',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用印申请';

-- ----------------------------
-- Records of t_signet_apply
-- ----------------------------
INSERT INTO `t_signet_apply` VALUES ('1', '1', '1', null, '1', '1', null, '1', '1', '1492419292314', '1492419292314', '1', '1', null, null);
INSERT INTO `t_signet_apply` VALUES ('2', null, '2', null, null, null, null, null, null, '1492425648103', '1492425648103', '1', '1', null, null);

-- ----------------------------
-- Table structure for t_signet_apply_file
-- ----------------------------
DROP TABLE IF EXISTS `t_signet_apply_file`;
CREATE TABLE `t_signet_apply_file` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `signet_applyid` bigint(20) NOT NULL COMMENT '印章申请ID',
  `beforesignet` longtext COMMENT '用印前文件',
  `aftersignet` bigint(20) DEFAULT NULL COMMENT '用印后文件',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用印文件';

-- ----------------------------
-- Records of t_signet_apply_file
-- ----------------------------

-- ----------------------------
-- Table structure for t_travel
-- ----------------------------
DROP TABLE IF EXISTS `t_travel`;
CREATE TABLE `t_travel` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `reason` varchar(100) DEFAULT NULL COMMENT '出差原因',
  `destation` varchar(20) DEFAULT NULL COMMENT '目的地',
  `start_time` bigint(20) DEFAULT NULL COMMENT '开始时间',
  `end_time` bigint(20) DEFAULT NULL COMMENT '实际结束时间',
  `expectend_time` bigint(20) DEFAULT NULL COMMENT '预计结束时间',
  `expectcost` double(8,2) DEFAULT NULL COMMENT '预计花费',
  `cost` double(8,2) DEFAULT NULL COMMENT '实际花费',
  `gm_time` bigint(20) DEFAULT NULL COMMENT '总经理审批时间',
  `gm_result` varchar(10) DEFAULT NULL COMMENT '总经理审批结果',
  `gm_suggest` varchar(100) DEFAULT NULL COMMENT '总经理审批意见',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='差旅申请';

-- ----------------------------
-- Records of t_travel
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `realname` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `departmentid` bigint(20) DEFAULT NULL COMMENT '部门',
  `loginname` varchar(100) DEFAULT NULL COMMENT '登录名',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建人',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户管理';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2', '1', '1', '1', '1', '1492418686108', '1492418686108', '1', '1', null, null);
