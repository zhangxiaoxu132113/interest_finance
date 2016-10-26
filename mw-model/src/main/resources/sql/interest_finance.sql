/*
Navicat MySQL Data Transfer

Source Server         : aidexin
Source Server Version : 50529
Source Host           : pc-20150903c016:3306
Source Database       : interest_finance

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2016-09-22 17:57:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_web_manager
-- ----------------------------
DROP TABLE IF EXISTS `b_web_manager`;
CREATE TABLE `b_web_manager` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PICID` int(11) DEFAULT '0',
  `DESCRIPTION` varchar(255) DEFAULT '',
  `URL` varchar(255) DEFAULT '',
  `SORTORDER` int(11) DEFAULT '0',
  `MANAGER_MODULE` int(11) DEFAULT '0' COMMENT '(外键数据字典的ddlcode)对应的每一条信息所属的网站管理模块，such，友情链接，合作机构',
  `WEB_DESCRIPTION` varchar(500) DEFAULT NULL,
  `WEB_KEY` varchar(500) DEFAULT NULL,
  `INDEX_TITLE` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_web_manager
-- ----------------------------
INSERT INTO `b_web_manager` VALUES ('29', '28', '', 'www.fujinli.com', '2', '1', null, null, null);
INSERT INTO `b_web_manager` VALUES ('30', '29', '', 'www.baidu.com', '34', '1', null, null, null);
INSERT INTO `b_web_manager` VALUES ('31', '30', '', 'www.baidu.com', '2', '1', null, null, null);
INSERT INTO `b_web_manager` VALUES ('39', '0', '', '', '0', '0', '兴趣金融，p2p合作平台', 'P2P，合作平台', '艾德信兴趣金融');
INSERT INTO `b_web_manager` VALUES ('40', '0', '网贷之家', 'www.wangdaizhijia.com', '3', '2', null, null, null);
INSERT INTO `b_web_manager` VALUES ('41', '0', '富金利', 'www.fujinli.com', '4', '2', null, null, null);
INSERT INTO `b_web_manager` VALUES ('42', '31', '新新贷', 'www.xinxindai.com', '34', '3', null, null, null);
INSERT INTO `b_web_manager` VALUES ('43', '32', '收贷天下', 'www.shoutian.com', '23', '3', null, null, null);
INSERT INTO `b_web_manager` VALUES ('44', '33', '国金宝', 'www.guojin.com', '54', '3', null, null, null);
INSERT INTO `b_web_manager` VALUES ('45', '34', '抱财网', 'www.baocai.com', '49', '3', null, null, null);

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity` (
  `ID` int(11) NOT NULL COMMENT '主键',
  `TITLE` varchar(255) DEFAULT NULL COMMENT '活动名称',
  `CONTENT` varchar(3000) DEFAULT NULL COMMENT '活动内容',
  `DESCRIPTION` varchar(3000) DEFAULT NULL COMMENT '活动的规则',
  `ARTICLE_MODULE` int(11) DEFAULT NULL COMMENT '所属的模块',
  `CREATEUSERID` int(11) DEFAULT NULL COMMENT '活动的创建者',
  `BEGINTIME` datetime DEFAULT NULL COMMENT '活动开始时间',
  `ENDTIME` datetime DEFAULT NULL COMMENT '活动结束时间',
  `CREATEDON` datetime DEFAULT NULL COMMENT '表数据创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_activity
-- ----------------------------

-- ----------------------------
-- Table structure for t_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_answer`;
CREATE TABLE `t_answer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION_ID` int(11) DEFAULT NULL COMMENT '问题ID',
  `EMPLOYEE _ID` int(11) NOT NULL COMMENT '回复问题的员工ID',
  `CONTENT` varchar(2000) DEFAULT NULL COMMENT '回复的内容',
  `SCORE_LEVEL_ONE` int(11) DEFAULT NULL COMMENT '问题的满意度one为满意',
  `SCORE_LEVEL_TWO` int(11) DEFAULT NULL COMMENT '问题的满意度two一般',
  `SCORE_LEVEL_THREE` int(11) DEFAULT NULL COMMENT '问题的满意度three不满意',
  `CREATEDON` datetime DEFAULT NULL COMMENT '回复的时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_answer
-- ----------------------------

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `ARID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `TITLE` varchar(255) DEFAULT NULL COMMENT '文章标题',
  `SUMMARY` varchar(1000) DEFAULT NULL COMMENT '文章的概要',
  `CONTENT` varchar(3000) DEFAULT NULL COMMENT '文章的内容',
  `HITS` int(11) DEFAULT '0' COMMENT '文章的点击量',
  `CREATEUSERID` int(11) DEFAULT NULL COMMENT '文章的创建者',
  `ARTICLE_MODULE` int(11) DEFAULT NULL COMMENT '文章的所属模块',
  `CREATEDON` datetime DEFAULT NULL COMMENT '文章的发表时间',
  PRIMARY KEY (`ARID`),
  KEY `fk_t_article_ t_empinfo_1` (`CREATEUSERID`),
  KEY `fk_t_article_t_article_module_1` (`ARTICLE_MODULE`),
  CONSTRAINT `fk_t_article_ t_empinfo_1` FOREIGN KEY (`CREATEUSERID`) REFERENCES `t_empinfo` (`ID`),
  CONSTRAINT `fk_t_article_t_article_module_1` FOREIGN KEY (`ARTICLE_MODULE`) REFERENCES `t_article_module` (`AMID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('1', '的地方地方', '互联网金融的公司', '<p>是对付的方法</p>\n', '0', '12', '7', '2016-09-22 10:39:01');
INSERT INTO `t_article` VALUES ('2', '富金利中秋送福利活动公告', '文章的简介', '<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\">尊敬的富金利用户：</span></p>\n\n<p>&nbsp;</p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family:微软雅黑\">一年一度的中秋佳节即将来临，富金利感恩回馈新老投资用户，为您送上佳节福利！</span></span></p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\">具体福利详情如下：</span></p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\">登录即领加息券！</span></p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\"><span style=\"font-family:微软雅黑\">领取时间：</span>2016年9月14<span style=\"font-family:微软雅黑\">日</span>12：00&nbsp;<span style=\"font-family:微软雅黑\">至&nbsp;</span>2016年9月18<span style=\"font-family:微软雅黑\">日</span>23:59</span></p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\">具体奖励：</span></p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\">&nbsp;1. 3张2%加息券<span style=\"font-family:微软雅黑\">；</span></span></p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\">&nbsp;2. 3张3%加息券<span style=\"font-family:微软雅黑\">；</span></span></p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\"><span style=\"font-family:微软雅黑\">加息券使用有效期：</span>15天</span></p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\">适用标的：除新手标以外的所有标的</span></p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\">奖励方式：在福利领取时间范围内，第一次登录富金利账户自动发送至账户</span></p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\"><span style=\"font-family:微软雅黑\">奖励发放后，可登录富金利账户在</span>&ldquo;我的账户&mdash;我的优惠券&rdquo;进行查看。</span></p>\n\n<p>&nbsp;</p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\">感谢您对富金利的关注与支持，祝您投资愉快！</span></p>\n', '0', '12', '8', '2016-09-22 10:37:29');
INSERT INTO `t_article` VALUES ('3', '关于取消富金利周年庆线下活动的公告', '活动的公告', '<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\">尊敬的富金利投资人：</span></p>\n\n<p>&nbsp;</p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\">&nbsp; &nbsp; &nbsp; &nbsp;2016年8月24日下午，银监会召开新闻发布会并正式下发《网络借贷信息中介机构业务活动管理暂行办法》（以下简称《暂行办法》）；至此网络借贷行业监管方案最终尘埃落定。</span></p>\n\n<p>&nbsp;</p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;富金利对《暂行办法》表示认同及欢迎，并且会严格按照《暂行办法》的相关规定执行。《暂行办法》的出台，标志着国家监管层对网络借贷行业的认可，同时，《暂行办法》细则公布，也给了富金利更明确的行为规范与指导方向。</span></p>\n\n<p>&nbsp;</p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\"><span style=\"font-family:微软雅黑; font-size:14px\">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style=\"font-size:16px\">根</span></span><span style=\"font-family:微软雅黑\">据《</span><span style=\"font-family:微软雅黑\">网络借贷信息中介机构业务活动管理暂行办法》第三章第十条第四点的相关规定，网络借贷信息中介机构不得&ldquo;自行或委托、授权第三方在互联网、固定电话、移动电话等电子渠道以外的物理场所进行宣传或推介融资项目&rdquo;。为了积极响应监管相关要求，不开展线下宣传活动，我们决定取消原定于9月3日举行的周年庆线下活动，由此给您带来的不便，敬请谅解！根据《暂行办法》的相关要求，富金利将会坚守网络信息中介的角色定位，在合规的基础上，通过互联网渠道，给广大投资人提供优质的金融信息中介服务，也请广大投资人一如既往的支持并监督富金利的工作！</span></span></p>\n\n<p><span style=\"font-family:微软雅黑,microsoft yahei; font-size:16px\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span></p>\n\n<p style=\"text-align:right\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-size:16px\">&nbsp;&nbsp;&nbsp;深圳市富金利互联网金融服务有限公司</span></p>\n\n<p style=\"text-align:right\"><span style=\"font-size:16px\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2016年9月2日</span></p>\n', '0', '12', '7', '2016-09-22 10:49:33');

-- ----------------------------
-- Table structure for t_article_module
-- ----------------------------
DROP TABLE IF EXISTS `t_article_module`;
CREATE TABLE `t_article_module` (
  `AMID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MODULE_CODE` varchar(250) DEFAULT NULL COMMENT '文章的CODE',
  `MODULE_NAME` varchar(250) DEFAULT NULL COMMENT '文章模块名称',
  `PARTENT_MODULE` int(11) DEFAULT NULL COMMENT '父级模块',
  `SORTORDER` int(11) DEFAULT NULL COMMENT '排序',
  `REMARK` varchar(250) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`AMID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article_module
-- ----------------------------
INSERT INTO `t_article_module` VALUES ('3', 'about', '关于我们', '0', '32', 'å³äºæä»¬');
INSERT INTO `t_article_module` VALUES ('4', 'financeSchool', '金融学院', '0', '23', 'éèå­¦é¢');
INSERT INTO `t_article_module` VALUES ('5', 'companyTerm', '公司团队', '0', '34', 'å¬å¸å¢é');
INSERT INTO `t_article_module` VALUES ('7', 'industry_information', '行业资讯', '0', '12', '发布行业的相关资讯');
INSERT INTO `t_article_module` VALUES ('8', 'company_announcement', '公司公告', '0', '13', '公司发布的公告新闻');

-- ----------------------------
-- Table structure for t_bank_card
-- ----------------------------
DROP TABLE IF EXISTS `t_bank_card`;
CREATE TABLE `t_bank_card` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) DEFAULT NULL COMMENT '用户ID',
  `ACCOUNT_NAME` varchar(100) DEFAULT NULL COMMENT '开户名',
  `CARDID` varchar(20) DEFAULT NULL COMMENT '用户身份证ID',
  `BANK_CARD_NO` varchar(30) DEFAULT NULL COMMENT '银行卡号',
  `BANK_CODE` int(11) DEFAULT NULL COMMENT '银行CODE值',
  `BANK_BRANCH` varchar(100) DEFAULT NULL COMMENT '开户支行',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bank_card
-- ----------------------------
INSERT INTO `t_bank_card` VALUES ('3', '13', '张', '32342343', '231232', '2', '中国银行', '2016-09-12 13:35:00');
INSERT INTO `t_bank_card` VALUES ('4', '13', '中文', '441522199312010638', '44556654556566', '0', '农业银行', '2016-09-12 13:35:04');
INSERT INTO `t_bank_card` VALUES ('5', '13', '张淼洁', '441522199312010638', '6217007200040634571', '0', '工商银行', '2016-09-16 13:35:08');
INSERT INTO `t_bank_card` VALUES ('6', '13', '张淼洁', '44152219931201038', '6217621762176217132', '0', '邮政储蓄', '2016-09-11 13:35:15');
INSERT INTO `t_bank_card` VALUES ('8', '31', '张三', '452627458625468542', '62548654512', '1', '中国银行', '2016-09-20 17:34:40');
INSERT INTO `t_bank_card` VALUES ('9', '31', '李四', '4546132365464', '465461313148478998', '2', '兴业银行', '2016-09-21 13:34:14');
INSERT INTO `t_bank_card` VALUES ('10', '31', '张三', '452485199605045246', '524685485245698745', '1', '农业银行', '2016-09-21 14:31:29');
INSERT INTO `t_bank_card` VALUES ('11', '31', '测试一', '152485632548754256', '542156874521536485', '1', '浦发银行', '2016-09-22 15:54:28');

-- ----------------------------
-- Table structure for t_bid
-- ----------------------------
DROP TABLE IF EXISTS `t_bid`;
CREATE TABLE `t_bid` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PLATFORMID` int(11) DEFAULT NULL COMMENT '所属平台的ID',
  `NAME` varchar(255) DEFAULT NULL COMMENT '标的名称',
  `DESCRIPTION` varchar(2000) DEFAULT NULL COMMENT '标的描述信',
  `TOTALCAPITAL` int(11) DEFAULT NULL COMMENT '标的总额',
  `QUOTA` int(11) DEFAULT NULL COMMENT '投标限额',
  `ANNUALRATE` float(11,3) DEFAULT NULL COMMENT '年化率（项目收益）',
  `SELF_ANNUALRATE` float(11,3) DEFAULT NULL COMMENT '平台提供的年化率',
  `TERM` int(11) DEFAULT NULL COMMENT '期限（应该使用什么数据呢？）',
  `STARTAMOUNT` int(11) DEFAULT NULL COMMENT '起投金额',
  `REPAYMENT_WAY` int(11) DEFAULT NULL COMMENT '还款方式',
  `BEARING_WAY` int(11) DEFAULT NULL COMMENT '计息方式',
  `SAFEGUARD_WAY` int(11) DEFAULT NULL COMMENT '保障方式',
  `MODULE` int(11) DEFAULT NULL COMMENT '所属模块（新手菜地，天天收菜）',
  `CREATEON` datetime DEFAULT NULL COMMENT '数据生成时间',
  PRIMARY KEY (`ID`),
  KEY `fk_t_ip_project_t_investmentPlatform_1` (`PLATFORMID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bid
-- ----------------------------
INSERT INTO `t_bid` VALUES ('6', '6', '银河·鸿运理财檀铭5期', '1、菜主跳转后请核对标的信息，投错或超出限额不计入返利，使用加息券跳转后，将暂时冻结加息券；\n\n2、为保证获得加息，请您注册p2p理财平台账户时，手机号、用户身份信息真实有效并与生菜网保持一致 （如您注册来源不是通过生菜网，不可获得生菜返利）；', '500000', null, '0.150', '0.010', '1', '100', '1', '1', '2', '1', '2016-09-01 11:37:28');
INSERT INTO `t_bid` VALUES ('7', '8', '季度盈160901-1', '微贷网优选计划是微贷(杭州)金融信息服务有限公司推出的以投资微贷网平台上优选标的、简化用户挑选、并提供稳健收益的智能投标产品。微贷网平台通过多层风控把关，严格的标的筛选、挑选出优质标的，通过分散投标，降低投资风险，最大化用户的资金使用率，保障用户达成预期收益率。 购买优选计划产品之后，资金无闲置立即开始投标，标的投满审核通过后，即进入投资锁定期，投资锁定期1个月后，本金收益一并返还到投资账户中。', '500000', null, '0.120', '0.020', '8', '500', '3', '3', '3', '1', '2016-09-01 13:47:03');
INSERT INTO `t_bid` VALUES ('8', '10', '担保365号第E期', '本项目融资总额350万元，本期线上发售50万元，周期3个月，年化收益率10%， 起投额度100元，单次投资最高额度50万元。由跃天财富融资担保有限公司提供全额本息担保，还款方式为按月付息到期还本，持有30天后可通过债权转让功能 进行转让。', '200000', null, '0.100', '0.040', '3', '1000', '2', '3', '2', '1', '2016-09-01 13:48:40');
INSERT INTO `t_bid` VALUES ('9', '12', '积木盒子固收理财3月标', '（不支持自动投标模式）', '500000', null, '0.110', '0.020', '3', '1000', '1', '3', '1', '2', '2016-09-01 14:39:07');
INSERT INTO `t_bid` VALUES ('10', '15', '中小企业短期资金周转（债权编号：FA0830H0058）', '抵押贷', '50000', null, '0.120', '0.030', '6', '500', '1', '2', '3', '2', '2016-09-01 14:47:21');
INSERT INTO `t_bid` VALUES ('11', '7', '转贷宝3月标', '30天内投资有效', '500000', null, '0.120', '0.030', '6', '100', '1', '2', '1', '2', '2016-09-01 16:03:55');
INSERT INTO `t_bid` VALUES ('12', '16', '中小企业短期资金周转（债权编号：FA0830H0058）', '抵押贷', '50000', null, '0.100', '0.060', '4', '100', '1', '1', '3', '2', '2016-09-01 16:05:34');
INSERT INTO `t_bid` VALUES ('13', '9', '季度盈160901-1', '请认真仔细查看注意事项：\n\n1、菜主跳转后请核对标的信息，投错或超出限额不计入返利，使用加息券跳转后，将暂时冻结加息券；\n\n2、为保证获得加息，请您注册p2p理财平台账户时，手机号、用户身份信息真实有效并与生菜网保持一致 （如您注册来源不是通过生菜网，不可获得生菜返利）；', '80000', null, '0.110', '0.030', '3', '1000', '1', '2', '2', '2', '2016-09-01 16:06:29');
INSERT INTO `t_bid` VALUES ('14', '14', '201608-006期', '新手专享标', '80000', null, '0.120', '0.020', '3', '500', '1', '1', '1', '2', '2016-09-01 16:07:57');

-- ----------------------------
-- Table structure for t_city
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `CID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `PID` int(11) DEFAULT NULL COMMENT '省对应的主键',
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_city
-- ----------------------------

-- ----------------------------
-- Table structure for t_code
-- ----------------------------
DROP TABLE IF EXISTS `t_code`;
CREATE TABLE `t_code` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `TEL_PHONE` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `RANDOM_CODE` varchar(255) DEFAULT NULL COMMENT '随机号码（六位数）',
  `CREATEON` datetime DEFAULT NULL COMMENT '验证码生成时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_code
-- ----------------------------

-- ----------------------------
-- Table structure for t_commsg
-- ----------------------------
DROP TABLE IF EXISTS `t_commsg`;
CREATE TABLE `t_commsg` (
  `MSGID` int(11) NOT NULL,
  `TITLE` varchar(255) DEFAULT NULL,
  `CONTENT` varchar(2000) DEFAULT NULL,
  `CREATEDON` datetime DEFAULT NULL,
  `CREATEUSERID` int(11) DEFAULT NULL,
  PRIMARY KEY (`MSGID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_commsg
-- ----------------------------

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `DEPARTMEN_ID` int(11) NOT NULL COMMENT '主键',
  `DEPARTMEN_NAME` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `DEPARTMEN_HEAD` int(11) DEFAULT NULL COMMENT '部门负责人（外键）',
  PRIMARY KEY (`DEPARTMEN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '运营策划', '1');
INSERT INTO `t_department` VALUES ('2', '电销部门', '2');
INSERT INTO `t_department` VALUES ('3', '客服部门', '3');

-- ----------------------------
-- Table structure for t_empinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_empinfo`;
CREATE TABLE `t_empinfo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `EMPLOYEE _ID` int(11) NOT NULL DEFAULT '0' COMMENT '员工编号',
  `USERNAME` varchar(250) NOT NULL COMMENT '昵称/登录名',
  `PASSWORD` varchar(250) NOT NULL COMMENT '用户密码',
  `EMPLOYEE_NAME` varchar(250) DEFAULT NULL COMMENT '员工姓名',
  `DEPARTMEN_ID` int(11) DEFAULT NULL COMMENT '所属部门ID',
  `GENDER` int(11) DEFAULT NULL COMMENT '性别',
  `BRITHDAY` datetime DEFAULT NULL COMMENT '出生日期',
  `POLITICS_STATAS` int(11) DEFAULT NULL COMMENT '政治面貌',
  `MARRIAGE` int(11) DEFAULT NULL COMMENT '婚姻状态',
  `ADRRESS` varchar(250) DEFAULT NULL COMMENT '家庭地址',
  `EMAL` varchar(250) DEFAULT NULL COMMENT '电子邮件',
  `PHONE` varchar(250) DEFAULT NULL COMMENT '电话号码',
  `JOB` int(11) DEFAULT NULL COMMENT '身份证',
  `CREATEDON` datetime DEFAULT NULL COMMENT '用户的创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_empinfo
-- ----------------------------
INSERT INTO `t_empinfo` VALUES ('12', '123', 'zhangsan', '123456', '张小凡', '2', '2', '2016-09-12 17:45:09', '1', '2', '陆丰市东海镇', 'mrwater1201@gmail.com', '15820310498', '1', '2016-09-12 17:45:37');
INSERT INTO `t_empinfo` VALUES ('13', '124', 'lisi', 'lisi', '李四', '1', '3', '2016-09-08 16:42:06', '1', '3', '深圳市福田区', '136218949@qq.com', '15017916946', '2', '2016-09-08 16:39:56');
INSERT INTO `t_empinfo` VALUES ('14', '125', 'wangwu', 'wangwu', '王五', '2', '1', '2016-09-13 00:00:00', '2', '2', '深圳市福田区', '136665@qq.com', '15017916946', '2', '2016-09-08 17:52:28');
INSERT INTO `t_empinfo` VALUES ('15', '126', 'admin', '123', '管理员1', '1', '1', '2016-09-21 13:38:24', '1', '2', '深圳市南山区', '123456@qq.com', '13654826241', '1', '2016-09-21 13:39:16');

-- ----------------------------
-- Table structure for t_friends_invitation
-- ----------------------------
DROP TABLE IF EXISTS `t_friends_invitation`;
CREATE TABLE `t_friends_invitation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USERID` int(11) DEFAULT NULL COMMENT '发起邀请的用户ID',
  `FRIENDID` int(11) DEFAULT NULL COMMENT '受邀请的用户ID',
  `INVIATION_WAY` int(11) DEFAULT NULL COMMENT '邀请方式',
  `CREATEDON` datetime DEFAULT NULL COMMENT '用户邀请的时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_friends_invitation
-- ----------------------------
INSERT INTO `t_friends_invitation` VALUES ('13', '15', '31', '1', '2016-08-29 16:24:44');
INSERT INTO `t_friends_invitation` VALUES ('14', '13', '15', '1', '2016-08-06 11:38:07');

-- ----------------------------
-- Table structure for t_img
-- ----------------------------
DROP TABLE IF EXISTS `t_img`;
CREATE TABLE `t_img` (
  `IMGID` int(11) NOT NULL AUTO_INCREMENT,
  `IMGURL` varchar(255) DEFAULT NULL COMMENT '图片地址',
  PRIMARY KEY (`IMGID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_img
-- ----------------------------
INSERT INTO `t_img` VALUES ('1', '/asset/content/touxiang.jpg');
INSERT INTO `t_img` VALUES ('2', 'upload/2016-08-24 10-30-33/7fc6aded-178a-4803-809e-f9b67946f4ab.jpg');
INSERT INTO `t_img` VALUES ('3', 'upload/2016-08-24 10-40-26/0de29161-e2c0-471b-b8e1-f021a6a549ce.jpg');
INSERT INTO `t_img` VALUES ('4', 'upload/2016-08-24 10-41-54/4a338af8-420c-400c-8a44-93c53bb22244.jpg');
INSERT INTO `t_img` VALUES ('5', 'upload/2016-08-24 10-41-54/4a338af8-420c-400c-8a44-93c53bb22244.jpg');
INSERT INTO `t_img` VALUES ('6', 'upload/2016-08-24 10-41-54/4a338af8-420c-400c-8a44-93c53bb22244.jpg');
INSERT INTO `t_img` VALUES ('7', 'upload/2016-08-24 10-44-09/f57eac0e-4194-4f62-bf52-fa0d7eee62bb.jpg');
INSERT INTO `t_img` VALUES ('8', 'upload/2016-08-24 10-44-09/f57eac0e-4194-4f62-bf52-fa0d7eee62bb.jpg');
INSERT INTO `t_img` VALUES ('9', 'upload/2016-08-24 10-44-09/f57eac0e-4194-4f62-bf52-fa0d7eee62bb.jpg');
INSERT INTO `t_img` VALUES ('10', 'upload/2016-08-24 10-44-09/f57eac0e-4194-4f62-bf52-fa0d7eee62bb.jpg');
INSERT INTO `t_img` VALUES ('11', 'upload/2016-08-24 10-44-09/f57eac0e-4194-4f62-bf52-fa0d7eee62bb.jpg');
INSERT INTO `t_img` VALUES ('12', 'upload/2016-08-24 10-44-09/f57eac0e-4194-4f62-bf52-fa0d7eee62bb.jpg');
INSERT INTO `t_img` VALUES ('13', 'upload/2016-08-24 10-44-09/f57eac0e-4194-4f62-bf52-fa0d7eee62bb.jpg');
INSERT INTO `t_img` VALUES ('14', 'upload/2016-08-24 10-44-09/f57eac0e-4194-4f62-bf52-fa0d7eee62bb.jpg');
INSERT INTO `t_img` VALUES ('15', 'upload/2016-08-24 10-59-13/acfea2a3-e202-42c0-8dba-f32d246f7c20.jpg');
INSERT INTO `t_img` VALUES ('16', 'upload/2016-08-24 11-20-30/c0b6be21-3df1-44bd-a429-2a008050076b.png');
INSERT INTO `t_img` VALUES ('17', 'upload/2016-08-25 01-46-02/5c4db33a-8ca6-45fa-90f7-469e7d014221.png');
INSERT INTO `t_img` VALUES ('18', 'upload/2016-08-25 05-05-29/d73b7c93-dc53-40a4-b83a-5855cad79ff7.png');
INSERT INTO `t_img` VALUES ('19', 'upload/2016-08-25 05-05-29/d73b7c93-dc53-40a4-b83a-5855cad79ff7.png');
INSERT INTO `t_img` VALUES ('20', 'upload/2016-08-25 05-06-31/d7741c5c-37c9-406d-9d13-34934774b312.jpg');
INSERT INTO `t_img` VALUES ('21', 'upload/2016-08-25 09-14-08/30a78e75-0c93-46c0-8b57-6aa21014bf42.png');
INSERT INTO `t_img` VALUES ('22', 'upload/2016-08-29 10-30-10/3df903c9-319f-4ba2-a45f-36a0dcf5366e.png');
INSERT INTO `t_img` VALUES ('23', 'upload/2016-08-29 17-57-43/e4ebf6ff-c4aa-44eb-9595-af92e37b5d25.jpg');
INSERT INTO `t_img` VALUES ('24', 'upload/2016-08-29 17-58-19/4976a7b6-4d4f-4200-ac1a-6c40c95876a4.png');
INSERT INTO `t_img` VALUES ('25', 'upload\\2016-09-01 14-29-08\\4a08746f-473d-4ee4-87cb-acb151e33ea2.jpg');
INSERT INTO `t_img` VALUES ('26', 'upload\\2016-09-01 14-29-21\\2250be97-013d-4405-bf6f-be0c3f0b2d0d.jpg');
INSERT INTO `t_img` VALUES ('27', 'upload\\2016-09-01 14-29-34\\98d26831-655b-4586-8cb5-2e9e5a5acbcb.jpg');
INSERT INTO `t_img` VALUES ('28', 'upload\\2016-09-01 14-32-21\\c49d8e69-d63f-423e-a94c-f422d47ca4de.png');
INSERT INTO `t_img` VALUES ('29', 'upload\\2016-09-01 14-32-35\\badea440-0341-449d-8f10-e02756ff0bcc.png');
INSERT INTO `t_img` VALUES ('30', 'upload\\2016-09-01 14-32-45\\342e6402-7f03-49ea-9ef5-604120493158.png');
INSERT INTO `t_img` VALUES ('31', 'upload\\2016-09-22 16-23-54\\c446f704-a93d-481b-80f2-1b2be1651e95.jpg');
INSERT INTO `t_img` VALUES ('32', 'upload\\2016-09-22 16-32-47\\5b89a876-9744-4d16-8dfb-6ca83f0ab8a4.jpg');
INSERT INTO `t_img` VALUES ('33', 'upload\\2016-09-22 16-33-22\\a578a21f-bc6a-4e5e-9d99-cd8dc8acdcde.jpg');
INSERT INTO `t_img` VALUES ('34', 'upload\\2016-09-22 16-34-33\\61e87372-5fe0-456d-bea0-d63a3accfdf2.jpg');

-- ----------------------------
-- Table structure for t_interest_rate_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_interest_rate_coupon`;
CREATE TABLE `t_interest_rate_coupon` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_interest_rate_coupon
-- ----------------------------

-- ----------------------------
-- Table structure for t_investmentplatform
-- ----------------------------
DROP TABLE IF EXISTS `t_investmentplatform`;
CREATE TABLE `t_investmentplatform` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `P_NAME` varchar(250) DEFAULT NULL COMMENT '平台的名称',
  `P_BACKGROUND` int(11) DEFAULT NULL COMMENT '平台背景（数据字典）',
  `C_NAME` varchar(250) DEFAULT NULL COMMENT '平台所属公司的名称',
  `REGISTERED_CAPITAL` int(20) DEFAULT NULL COMMENT '注册资金',
  `C_ADDRESS` varchar(255) DEFAULT NULL COMMENT '公司地址',
  `URL_ADDRESS` varchar(255) DEFAULT NULL COMMENT '平台网址',
  `TEL_PHONE` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `LOCAL_AREA` int(11) DEFAULT NULL COMMENT '所在地区(数据字典)',
  `SCORE` int(11) DEFAULT NULL COMMENT '用户评分',
  `LEGAL_REPERSENTATIVE` varchar(250) DEFAULT NULL COMMENT '法人代表',
  `UPTIME` datetime DEFAULT NULL COMMENT '上线时间',
  `PLATFORM_INTRODUCTION` varchar(3000) DEFAULT NULL COMMENT '平台介绍',
  `RECOMMENDED_REASON` varchar(3000) DEFAULT NULL COMMENT '推荐理由',
  `WIND_CONTROL_SITUATION` varchar(3000) DEFAULT NULL COMMENT '风控情况',
  `LOGO_IMG` varchar(255) DEFAULT NULL COMMENT '平台的logo图片',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_investmentplatform
-- ----------------------------
INSERT INTO `t_investmentplatform` VALUES ('5', '奇子向钱', '1', '北京奇子投资管理有限公司', '170000000', '北京市东城区朝阳门内银河soho-B座20903', 'https://www.qzxq.com/', '400-0677-333', null, null, '张福洋', '2016-07-01 00:00:00', '奇子向钱（qzxq.com）是奇子金服旗下专业的互联网金融第三方财富管理和资产交易平台，专注于为投资者提供安全、透明、便捷、低门槛、高收益的互联网理财及增值服务。100元即可加入平台理财计划，乐享便捷、趣味的创新理财方式和积分兑换服务。坚持高标准严格精选优质债权，并携手第三方资金实力担保机构，为投资者实现360°本息安全，让投资者财富得以安全升值。同时平台严格遵守相关规定，信息公开透明，资金安全可靠，CFCA电子签章安全认证及法律法规保障。平台还配备优良的设备设施与高端的技术人才，保护用户数据安全，是我们坚守的平台原则。 2016年1月，奇子向钱母公司奇子成新（上海）金融信息服务有限公司获得政府引导型基金强势注资，奇子向钱成为了有上市国资背景的互联网金融理财平台。', '奇子向钱拥有完善的风控体系，安全的保障措施。同时，平台已获得国资&上市背景公司融资，是互联网金融行业中安全优势排名靠前的服务平台。平台还拥有短期高收益产品，娱乐理财两不误的奇猜计划产品以及品质生活提前享的理财产品。', '1、奇子贷债权风险保障金 2、其他债权保证金+原始债权人回购 3、债权匹配，小散分散 4、独创9级数十层债权人筛选机制 5、CFCA安全认证 6、优良设备与高端技术人才保障技术安全', 'upload\\2016-09-01 10-04-25\\76165534-7fe9-4875-b1de-cf666ca3af23.jpg');
INSERT INTO `t_investmentplatform` VALUES ('6', '国金宝', '2', '上海银河惠理金融信息服务有限公司', '1000000000', '上海世纪大道100号环球金融中心71楼', 'http://www.guojinbao.com/', '400-0677-313', null, null, '成刚', '2014-09-26 00:00:00', '国金宝是由上海银河惠理金融信息服务有限公司设立，由两大国有企业中国少数民族经济文化开发总公司和北京中冶国瑞资产管理有限公司控股的国资系互联网金融平台。其立足上海，辐射全国的垂直型布局、强大的股东资本实力、优质的项目资源以及久经考验的风控体系，致力于为投资者打造产品类型、期限、收益等方面更多元化、个性化、定制化的全球互联网金融理财超市。 高额收益：平均年化收益率最高可达19.96%，秒杀银行活期利率 低入门槛：100元起投，参与投资和到期赎回完全免费 资金安全：独具立体化风险控制模式，打造多重安全壁垒，多面风控体系，保障本息安全。 一流团队：权威的专家顾问，强大的技术支持，完善的售后管理。', '国资委直属大型国有企业控股平台，由太平洋保险提供安全保障，并荣获“iTrust企业信用AA级评价”“2015年度互联网金融责任品牌奖”等多项专业认证，是真正将投资者的闲散资金与优质项目资源有效结合合，坚决保障投资者权益的专业互联网理财平台。 1万（含）以上不收取提现手续费，1万元以下每个自然月您都有1次免费提现机会，超过一次免费提现后2元/笔', '1、完整审核材料：根据风控大纲，要求融资企业提交完整的融资材料，严格审核银行流水、征信报告、工商资料、重大合同、还款来源证明等必需材料； 2、项目筛选及评级：根据融资企业的资信情况及历史运营情况，对融资企业进行初步评级，根据已审核的项目材料，选择符合风控要求的融资项目； 3、实地尽调：由风控团队对项目进行实地考察，约谈管理层，了解项目实际运作情况及融资企业生产经营状况，确保项目真实性，有稳定还款来源； 4、增信措施：根据项目类型、还款来源，采取不同的增信措施，如：借款人回购、实物抵押、关联方担保等', 'upload\\2016-09-01 10-17-29\\825a35e3-3a08-4383-9a0b-18152adc4068.jpg');
INSERT INTO `t_investmentplatform` VALUES ('7', '温商贷', '3', '浙江温商贷互联网金融服务有限公司', '230000000', '温州市鹿城区蒲中路222号（李山投资集团总部大楼）', 'http://www.wsloan.com/', '400-0677-331', null, null, '卢成堆', '2016-09-20 00:00:00', '温商贷2013年3月上线，上线以来总成交量109.6亿元，待收金额27.44亿元，主要经营标的类型为抵押标。业务主要来源由平台自主开发和第三方机构推荐。借款周期为1到12个月。', '2014年10月，温商贷获中国互联网协会AA级评级。2015年8月1日，温州温商贷金融信息服务股份有限公司“升级”为浙江温商贷互联网金融服务有限公司携手上市企业瓷爵士【证券代码：831441】挂牌上市。', '温商贷目前业务来源第三方机构推荐和平台团队自主开发，目前平台有自己的业务团队，平台单项目借款金额较大，借款企业较集中，平台主要选择中型企业做为客户群，对中型企业的项目进行补充借款，平台目前主要做温州当地房产借款项目。对借款资料的归档完善。', 'upload\\2016-09-01 10-20-41\\84858d35-f342-4535-9d5b-189ff6223a8f.jpg');
INSERT INTO `t_investmentplatform` VALUES ('8', '微贷网', '3', '微贷（杭州）金融信息服务有限公司', '1219500000', '杭州市江干区解放东路37号', 'https://www.weidai.com.cn/', '200-0677-333', null, null, '姚宏', '2016-09-04 00:00:00', '微贷网是杭州锐拓科技有限在10年立项，旨在为有资金需求和投资需求的小微企业和个人打造的一个规范安全高效诚信专注于汽车抵押借贷的中介服务平台。', '运营时间长-稳定，汽车抵押借贷-专而精，营业点遍布全国-实力强，风投青睐-前景好，专业风控 坏账低-靠谱，标的期限全面，收益高效。', '贷前：资料审核（个人征信 车子基本情况以及违章情况 电话审核再次信息确认鉴定贷款人还款能力）\n贷中：车子安装GPS监控系统\n贷后：定期电话回访 定期监控车子位置 近还款日 提前通知借款人还款以及催款。', 'upload\\2016-09-01 10-22-40\\03501bb8-7ed5-43b1-81f9-a054a96a7bcc.jpg');
INSERT INTO `t_investmentplatform` VALUES ('9', '惠农聚宝', '3', '北京银信天下网信息科技服务有限公司', '98000000', '北京市朝阳区光华路15号院1号楼泰达时代中心601', 'https://www.huinongjubao.com/', '400-0677-333', null, null, '陈景涛', '2016-09-30 00:00:00', '惠农聚宝（原爱财狼）由北京银信天下网信息科技服务有限公司管理运营，是面向互联网的第三方撮合机构，惠农聚宝倾力打造一个“以农业生产为核心、结合上下游产业链，服务三农，惠及城市”的农业产业链金融模式。本着小额分散的投资理念，以及结合农业生产场景与农民生活场景的实地考察与规范化审核，惠农聚宝力求为投资者提供一个安全，灵活，合理收益的理财环境。', '整合农业生产上下游资源，倾力打造“从嘴巴到钱袋”的农业金融产业链。', '精选优质债权——惠农计划投资的项目均是根据惠农助贷研发部的估值模，通风控人员对借款方的实地调查，并对其资质进行严格的风控审核后通过的资产。详细风控流程请见安全保障页。 分散投资、债权组合——系统算法将对投资人的资金进行分散，按最佳风险收益比构建灵活债权组合，最大限度的降低投资人由于投资过于集中产生的风险。 对原债务人企业尽职调查——包括但不限于财务情况调查、经营资质调查、信用记录调查、债务情况调查、涉诉情况调查、与原债权人交易历史调查。 检查核对原始《借款合同》和抵押证明无误。 第三方公司承诺债权回购。', 'upload\\2016-09-01 10-24-24\\d7246988-2f66-45f3-8929-c425af15823f.jpg');
INSERT INTO `t_investmentplatform` VALUES ('10', '花果金融', '2', '北京花果信息技术有限公司', '50000000', '北京市朝阳区望京东园523号融科望京中心A座1507', 'https://www.huaguo.cn/', '400-5247-333', null, null, '塔拉', '2016-09-14 00:00:00', '自2014年1月2日上线至今，花果金融不断创新产品结构，推出优质借款项目。目前，花果金融已完成借款筹资超过10亿元，助52638名投资人获得理财收益1亿4100万元。', '创新：自2014年1月2日上线至今，花果金融不断创新产品结构，推出优质借款项目。目前，花果金融已完成借款筹资超过10亿元，助47825名投资人获得理财收益1亿3195万元。 透明：花果金融是透明的互联网金融公司。公开和透明是进步的源泉，我们将最大程度公开业务数据和信息。您对花果的每一分关注和审视，都是我们前行的目标和动力。 成就：花果金融的服务为的是成就每一个投资人和借款人，通过资金的每一次流转，我们不仅希望它能帮助借款人筹得资金、给投资者带来收益，我们也在努力，用更多的增值服务成就借款人和投资者更幸', '根据项目不同，风控措施不同，常见的有抵押物、个人无限连带责任担保、担保机构全额本息担保等，具体要看项目，各项目担保情况可能不一样。', 'upload\\2016-09-01 10-25-56\\22b75196-5651-43a0-910a-f10de50fa46e.jpg');
INSERT INTO `t_investmentplatform` VALUES ('11', '金融圈', '1', '深圳福迈斯科技有限公司', '200000000', '深圳市南山区高新南四道航盛大厦19楼', 'http://www.jrq.com/', '400-0677-333', null, null, '毛大伟', '2016-09-11 00:00:00', '\"Formax Group Limited（简称：Formax 集团）成立于2012年，是一家致力于新兴变革的创新型互联网金融服务企业，在英国、新西兰、澳大利亚等境外有8家子公司，在北上广深等一二线城市设19处分支机构。2013年获得IDG、宜信和复星的千万美战略投资。目前拥有千名优秀的金融投资及互联网技术人才，雄厚的资金实力、先进的互联网技术、丰富的金融投资经验、遍布全球的金融资源使Formax 集团在金融服务领域里处于领先地位。 2014年Formax集团注册成立了深圳福迈斯科技有限公司（以下简称：福迈斯），注册资金2亿元人民币，是一家立足于深圳发展起来的高成长、高科技、高附加值的“科技+金融”型企业。福迈斯是Formax集团在全球唯一的互联网技术研发中心，主要对接Formax集团所有金融产品在互联网上的研发及运营，目前拥有将近400名优秀的互联网人才，其中本科以上学历占75%，是一个充满活力和爆发力的专业团队。 成立至今，Formax 集团始终以用户体验为依据，以推动行业良性发展为己任，通过多项自主研发的技术成功打造了国内第一个多元化投资的金融服务平台——“Formax金融圈”。Formax 集团将“Formax金融圈”作为战略核心产品,致力于将平台打造成为全球互联网上最大的一站式金融交易社区。福迈斯通过与Formax集团内各关联公司签署了业务代理合作协议，将集团线下成熟的金融业务体系与互联网上的“Formax金融圈”平台进行无缝连接，现主要负责平台的研发及运营。Formax集团通过线上与线下结合的O2O模式不但有效地提高了用户的粘黏性，同时也增强了企业的优势竞争力。 “Formax金融圈”现主要在互联网上提供股票、基金、外汇、商品、P2P信贷等不同类型的投资品种，实现了一站式的金融交易模式，从而全方位、多层次、点对点地满足全球用户多样化的投资需求。通过平台在互联网上进行的各种投资交易无论在系统安全、资金安全还是风险控制都实行严格的把控，并且是在以之对应的金融监管体系之下进行，力求与向用户提供多元化、低风险、高效率的金融投资服务。 \"', '目前国内唯一一家拥有P2P牌照（英国金融市场行为监管局（FCA）经纪业务\\P2P借贷业务牌照）的互联网金融公司。公司业务涵盖外汇、港美股、基金、P2P等。注册资金2亿、获得明星风险投资IDG、复星、宜信战略领头。拥有7大牌照（中国天津市矿产资源交易所会员、中国私募投资基金管理人、英国金融市场行为监管局（FCA）经纪业务\\P2P借贷业务牌照、澳大利亚证券和投资委员会(ASIC)经纪业务牌照、新西兰金融管理局(FMA)金融衍生品交易\\经纪业务牌照、香港证券及期货事务监察委员会(SFC)证券买卖及融资\\资产管理', '纯债权抵押：房产抵押贷款、汽车抵押贷款。抵贷额不超过50%', 'upload\\2016-09-01 10-27-18\\706031da-9584-42f6-bcc1-e8b3d5b8cb65.jpg');
INSERT INTO `t_investmentplatform` VALUES ('12', '金投手', '3', '金投手金融信息服务(北京)有限公司', '200000', '北京市海淀区中关村丹棱街甲1号互联网金融中心B座22层', 'https://www.jintoushou.com/', '400-0677-333', null, null, '马俊湖', '2016-09-19 00:00:00', '金投手金融信息服务(北京)有限公司（以下简称金投手)是经北京市海淀区金融办批准成立的国资互联网金融信息中介服务平台，由北京粮油交易所、中建国能等央企法人发起成立，并携手北京联通共同打造的供应链金融平台，实缴注册资本金5000万元，办公地点位于北京中关村互联网金融中心。 金投手专注于为AA+央企、国企、上市公司提供整合性供应链金融服务，充分利用互联网技术、借助大数据金融和云计算、坚持业务创新，为优质核心企业的上下游产业建立产融结合的供应链金融体系。同时，携手世界500强电信巨头中国联通(北京公司)，夯实其市场优势，依托金投手的优质资产，通过创新“流量+资产”的互联网金融模式，为投资者提供安全可靠的互联网金融信息中介服务。 公司风控团队成员来自于银行、证券等传统金融机构及会计师事务所，技术及运营团队人员来自知名互联网企业。公司凭借行业经验及自身专业人才优势，始终致力于为客户提供全方位、个性化的金融服务，并为客户打造出一个诚信、透明、公平、高效的互联网金融服务平台。', '金投手是提供居间服务的互联网金融平台，为有投资需求的用户和有融资需求的融资方提供信息中介服务，办公地址位于中关村互联网金融中心，办公面积1500余平米，由中建国能、北京粮油交易所等央企及国有大型企业的法人股东出资成立，注册资本5000万元，实缴5000万元。', '精选优质债权,原始债务人经营稳定,还款能力强,信用优质； 国有商业保理公司承诺回购债权； 国有担保公司为用户提供本息保障； 金投手与第三方平台结算合作，所有资金均由连连支付进行第三方结算合作； 与海通证券、中国联通等达成战略合作。', 'upload\\2016-09-01 10-29-18\\4e1fa032-9b78-4f2f-a7a8-1506319a447d.jpg');
INSERT INTO `t_investmentplatform` VALUES ('13', '新新贷', '2', '新新贷（上海）金融信息服务有限公司', '5000000', '上海市虹口区四川北路859号28楼整层', 'http://www.xinxindai.com/', '400-0677-333', null, null, '张扬', '2012-09-13 00:00:00', '新新贷全称新新贷（上海）金融信息服务有限公司，成立于2012年2月，截至2015年10月，在全国设有41家分公司，中国互联网金融P2P信贷领军企业，专注于中小微用户提供金融信息服务，为中国最广大的用户提供一个安全高收益的财富增值通道。', '1、上海市互联网金融行业协会首批会员；\n2、“金罗盘奖”最稳健经营互联网金融理财平台； \n3、2015中国十佳P2P创新奖；\n4、全国首个金融信息行业协会副会长单位； 5、网贷评级“国家队”领跑A级平台；', '风控实力：风控团队的骨干出身民生、平安、渣打等银行风控系统，无论人数、专业程度、学历都堪称一流配置。 风险准备金：新新贷在光大银行开设专属风险准准备金账户，账户金额达3810万，且光大银行每月出据管理报告。 账户安全保障：世界500强PICC对平台的投资人账户进行承保。新新贷已通过PICC严格的平台风控能力审核。', 'upload\\2016-09-01 10-30-39\\3f8c96ee-2c37-41e4-b95e-db30444114f1.jpg');
INSERT INTO `t_investmentplatform` VALUES ('14', '鑫合汇', '1', '杭州鑫合汇网络科技有限公司', '25000000', '杭州市江干区城星路69号中天国开大厦9楼', 'https://www.xinhehui.com/', '400-0677-333', null, null, '胡德华', '2012-09-10 00:00:00', '中新力合旗下，以P2B为主要模式的互联网理财平台，于2013年12月02日上线 。平台主打优质理财，提供1~365天期限的理财产品，最低100元起投，且全天覆盖。所有投资产品均为融资担保机构全额本息担保标和实地调查认证标。用户资金安全由平安保险承保。具体可参见鑫合汇简介PPT。', '国资背景，上市金融公司旗下，多级风控保障。多家国内顶级担保公司100%本息担保。标的安全，用户资金安全，超高收益，超短期项目。行业排名第12。', '\"贷前：实地考察，多级专业评估\n贷中：多家国内顶级担保公司全额担保，旗下浙江省最大担保公司\n贷后：风控团队跟踪监控\"', 'upload\\2016-09-01 10-32-07\\c710d489-ed0b-4ea2-8200-9566582437da.jpg');
INSERT INTO `t_investmentplatform` VALUES ('15', '抱财网', '1', '北京中联创投电子商务有限公司', '50000000', '北京市海淀区海淀大街38号银科大厦8层', 'http://www.baocai.com/', '400-0677-333', null, null, '王尔明', '2012-09-12 00:00:00', '\"抱财网（www.baocai.com）是北京中联创投电子商务有限公 司旗下的专业化的互联网金融品牌总部位于北京，由来自金融、法 律、互联网、财务等领域的资深人士运营管理。\n2013年成立至今,抱财网用先进的理念和创新的技术建立了一 个安全、高效、专业、规范的互联网金融平台。恪守保障用户的资 金安全、确保资金的正确流向、积极优化产品结构的原则，不仅为 社会富余提供了一个稳定安全的投资渠道，更致力于扶持中国实体 经济的发展，为小微企业及创业者解决资金困难。\n作为国内最有潜力的互联网金融企业，抱财网将坚持产品的创 新及风险控制体系的创新，不断为平台客户提供优质的项目和服务 持续为中国普惠金融的发展贡献力量。\"', '定位于信息中介服务的互联网金融服务平台\n创新型线上投资理财平台', '\"抱财网（www.baocai.com）是北京中联创投电子商务有限公 司旗下的专业化的互联网金融品牌总部位于北京，由来自金融、法 律、互联网、财务等领域的资深人士运营管理。\n2013年成立至今,抱财网用先进的理念和创新的技术建立了一 个安全、高效、专业、规范的互联网金融平台。恪守保障用户的资 金安全、确保资金的正确流向、积极优化产品结构的原则，不仅为 社会富余提供了一个稳定安全的投资渠道，更致力于扶持中国实体 经济的发展，为小微企业及创业者解决资金困难。\n作为国内最有潜力的互联网金融企业，抱财网将坚持产品的创 新及风险控制体系的创新，不断为平台客户提供优质的项目和服务 持续为中国普惠金融的发展贡献力量。\"', 'upload\\2016-09-01 10-33-15\\b6a05056-9a69-4db2-b4b9-ec7bb67f8f42.jpg');
INSERT INTO `t_investmentplatform` VALUES ('16', '你我贷', '1', '上海你我贷金融信息服务有限公司', '10000000', '上海浦东新区杨高南路428号由由世纪广场1号楼17-20楼', 'http://www.niwodai.com/', '400-0677-333', null, null, '严定贵', '2016-09-07 00:00:00', '你我贷为上海嘉银金融服务有限公司旗下互联网金融平台，成立于2011年6月，旨在为有融资及投资需求的小微企业和个人建立起高效、透明、安全、便捷的互联网金融服务。自成立3年来，你我贷的服务已覆盖了全国近30余个省的100多个城市，通过平台对接的资金深入到中国最广大的二三线城市、乡镇地区及农村，帮助了数十万急需融资发展的小微企业和个体工商从业者通过信用申请获得融资贷款。现在，你我贷已成长为国内规模最大、最具实力的P2P网络借贷平台之一。', '“你我贷”开创性的以“资金红娘”的身份，借助广泛高效的网络媒介，调剂资金富余方与资金需求方的资金融通，满足双方的共同需求，实现双方的共赢。本着“帮助他人，快乐你我”的初心，你我贷在创立之始，就把信用管理和风险控制放在首位。', '贷前：差异化授信政策\n产品差异化：针对不同产品目标客户群的不同风险特征独立制定授信政策，对于不同的风险点进行重点揭露，以供信审人员日常执行。例如：嘉房贷产品对房贷认定规则予以明确规定。\n地区差异化：根据高风险地区进行政策“禁止进件”项的实时调整。例如：规定山东滨州、陕西榆林等地区禁止进件。\n行业差异化：针对高风险行业，政策明文规定“禁止进件”。例如：规定“国家去产能、去杠杆、高污染等行业从业人员”等十多个行业禁止进件。\n贷中：多级化信审流程\n每笔业务均须经过“初审”、“预审”、“终审”三个信审流程，有效规避因为人为主观判断或从业人员经验不足导致的信贷错判。\n审批通过后，我司特设“出账审查”岗位，对于客户在出账前所有流程所可能出现的风险点进行全方位审核，确保资金安全。\n贷后：逾期处理机制\n1、催收应对：除还款日提前短信提醒、电话提醒外，对于逾期客户由电催组进行电话催收，根据电催组了解到的实际情况，分析案情严重程度，交于不同级别有权人士进行再次电催；对于达到委外条件的，交予经我司认可的专业委外机构进一步实现债权。\n2、催收反馈：催收将定期汇总逾期案件特征，联合信审、作业、政策等多部门进行分析，及时调整授信政策和业务方向。在产品设计方面，对于逾期率高的产品及时逾期废除，或限制发售；对于地区性风险集中的区域，及时关停业务受理资格（截止目前，已有22家分公司的业务因逾期问题被不同程度地限制）。新上线的产品，将通过流程改造，人员培训，政策限制等方法降低逾期概率。', 'upload\\2016-09-01 10-35-08\\9371d8c8-fbd2-43ab-8063-32467e2ad279.jpg');
INSERT INTO `t_investmentplatform` VALUES ('17', '搜贷天下', '2', '富赛（天津）交易所投资管理有限公司', '10000000', '北京市海淀区高粱桥斜街59号中坤大厦14层', 'http://www.soudaitianxia.com/global/index.do', '400-0277-333', null, null, '古杨', '2016-09-13 00:00:00', '搜贷天下（www.soudaitianxia.com）是富赛交易所旗下的，与国内银行业金融机共同构建的银行系直销平台，公司注册资本4000万人民币。通过集团公司富赛交易所构建的“超级账户”体系，平台与全国金融资产交易所、银行业金融机构互联互通获取优质资产，并结合银行级风控体系、通过金融科技（Fintech）措施，智能化对资产进行最优配置，为广大投资用户提供稳健、安全的理财服务，实现财富的快速增值。截至2016年初，平台累计为17万用户提供的金融信息服务，实现交易额已突破亿元。 富赛交易所目前是国内第一家，也是唯一致力于为中国场外金融交易所的综合性解决方案提供商。先后参与北京金融资产交易所、新华社金融信息交易所、四川金融资产交易所、四川联合酒类交易所等交易所的投资、设计、建设与受托运营等工作。公司通自主研发的“超级账户”体系，构建了联通交易所、金融信息服务、互联网金融、直销银行、第三方支付、融资租赁、境外券商，新四版经纪的金融生态体系。截止2015年累计交易与管理资产已超万亿。', '与银行共通搭建的直销银行平台', '数据对称校验+SSL加密传输+数据加密储存：防范黑客攻击，保护用户隐私。 核心业务流程防护：严格的最高级别的安全防护与系统压力测试。 数据访问多层防护：阿里金融云、阿里云盾、硬件防火墙、业务层/核心交易层银行安全数据通道。 实名认证+同卡进出：体现只能到与投资者实名认证相同的身份证号的银行卡中。 手机提醒：资金发生任何变动时，短信即时提醒，用户随时掌控资金状况。 国政通实名认证：真实、有效的实名认证体系，对应绑卡人身份，保证用户的账户安全。 CFCA数字证书认证：银行级数字证书服务，为线上用户交易提供安全及法律保障。 同盾发欺诈系统：公司与同盾科技联手打造“互联网防火墙”在保障平台不受欺诈的同时，也保障了投资人的权益不受损害。 银行级别的多重风控流程： 投资前：额度限制，风险准备金 投资中：鼓励定存、严格投资者筛选、资金流动准备 投资后：流动性资产准备 风险备付金账户：公司常设风险备付金账户，大资金托底，如有风险，先行垫付，让投资人稳拿收益，更安心。 资产安全： 1、银行尽调和推荐的资产 2、在资本市场公开发行的信用级别在AA级别以上的债券资产 3、有国企/央企资产抵押或担保的半标或非标资产 合规保障： 1、第三方会计事务所：独立审计报告 2、第三方律师事务所：严格审核平台的风控体系', 'upload\\2016-09-01 10-36-21\\a12fbe01-22c2-4ecc-9bc0-ebf93e2cee19.jpg');
INSERT INTO `t_investmentplatform` VALUES ('18', '富金利', '3', '深圳市富金利互联网金融服务有限公司', '100000000', '深圳深南大道大庆大厦', 'http://www.fujinli.com/', '400-0677-333', null, null, '许先伟', '2015-09-14 00:00:00', '深圳市富金利互联网金融服务有限公司(www.fujinli.com)，成立于2011年12月15日，总部位于深圳，注册资本1.17亿元，实缴资本5000万元，是一家实施360°全天候全方位实时监控的创新型互联网公司》》点击观看办公直播，也是业内率先成立P2P网贷风控评审专委会的P2P网贷平台。富金利目前以投融资撮合、网络理财、金融服务为主营业务，与宝付支付签订资金第三方托管协议，4月6日已全面上线，致力于打造安全可靠的互联网金融平台。', '深圳市富金利互联网金融服务有限公司(www.fujinli.com)，成立于2011年12月15日，总部位于深圳，注册资本1.17亿元，实缴资本5000万元，是一家实施360°全天候全方位实时监控的创新型互联网公司》》点击观看办公直播，也是业内率先成立P2P网贷风控评审专委会的P2P网贷平台。富金利目前以投融资撮合、网络理财、金融服务为主营业务，与宝付支付签订资金第三方托管协议，4月6日已全面上线，致力于打造安全可靠的互联网金融平台。', '深圳市富金利互联网金融服务有限公司(www.fujinli.com)，成立于2011年12月15日，总部位于深圳，注册资本1.17亿元，实缴资本5000万元，是一家实施360°全天候全方位实时监控的创新型互联网公司》》点击观看办公直播，也是业内率先成立P2P网贷风控评审专委会的P2P网贷平台。富金利目前以投融资撮合、网络理财、金融服务为主营业务，与宝付支付签订资金第三方托管协议，4月6日已全面上线，致力于打造安全可靠的互联网金融平台。', 'upload\\2016-09-02 10-39-49\\3f84b07f-496a-4c66-8c85-e144ae6a6ebc.png');

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `LOGID` int(11) NOT NULL,
  `USERID` int(11) DEFAULT NULL,
  PRIMARY KEY (`LOGID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USERID` int(11) DEFAULT NULL COMMENT '用户ID',
  `LOGINTIME` datetime DEFAULT NULL COMMENT '当前登录时间',
  `CONTINUElOGINCNT` int(11) DEFAULT '0' COMMENT '连续登录次数',
  PRIMARY KEY (`ID`),
  KEY `login_log_user` (`USERID`),
  CONSTRAINT `login_log_user` FOREIGN KEY (`USERID`) REFERENCES `t_user` (`USERID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_login_log
-- ----------------------------
INSERT INTO `t_login_log` VALUES ('3', '13', '2016-09-20 16:22:51', '2');
INSERT INTO `t_login_log` VALUES ('5', '15', '2016-09-22 11:38:04', '2');
INSERT INTO `t_login_log` VALUES ('11', '31', '2016-09-22 12:37:18', '3');

-- ----------------------------
-- Table structure for t_message_global
-- ----------------------------
DROP TABLE IF EXISTS `t_message_global`;
CREATE TABLE `t_message_global` (
  `MSGID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `SENDER_ID` int(11) NOT NULL COMMENT '发送消息人ID',
  `MESSAGE_TITLE` varchar(255) DEFAULT NULL COMMENT '消息的标题',
  `MESSAGE_CONTENT` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '消息内容',
  `MESSAGE_TYPE` int(11) DEFAULT NULL COMMENT '消息类型(用户类型，用户组类型，全局类型)',
  `MESSAGE_PRIORITY` int(11) DEFAULT NULL COMMENT '消息等级',
  `SEND_TIME` datetime DEFAULT NULL COMMENT '消息发送时间',
  PRIMARY KEY (`MSGID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message_global
-- ----------------------------

-- ----------------------------
-- Table structure for t_message_log
-- ----------------------------
DROP TABLE IF EXISTS `t_message_log`;
CREATE TABLE `t_message_log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MESSAGE_ID` int(11) NOT NULL COMMENT '消息ID',
  `USER_ID` int(11) NOT NULL COMMENT '用户ID',
  `READ_STATUS` int(11) DEFAULT NULL COMMENT '阅读状态',
  `DELETE_STATUS` int(11) DEFAULT NULL COMMENT '删除状态',
  `READ_TIME` datetime DEFAULT NULL COMMENT '阅读时间',
  `DELETE_TIME` datetime DEFAULT NULL COMMENT '删除时间',
  `IS_STAR` varchar(255) DEFAULT NULL COMMENT '星级标记',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_message_one
-- ----------------------------
DROP TABLE IF EXISTS `t_message_one`;
CREATE TABLE `t_message_one` (
  `MSGID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `USERID` int(11) DEFAULT NULL COMMENT '接受人的ID',
  `SENDERID` int(11) NOT NULL COMMENT '发送消息人ID',
  `MESSAGE_TITLE` varchar(255) DEFAULT NULL COMMENT '消息的标题',
  `MESSAGE_CONTENT` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '消息内容',
  `MESSAGE_TYPE` int(11) DEFAULT NULL COMMENT '消息类型(用户类型，用户组类型，全局类型)',
  `MESSAGE_PRIORITY` int(11) DEFAULT NULL COMMENT '消息等级',
  `SEND_TIME` datetime DEFAULT NULL COMMENT '消息发送时间',
  `READ_STATUS` int(11) DEFAULT NULL COMMENT '阅读状态（0-还没有阅读，1-已经阅读）',
  `DELETE_STATUS` int(11) DEFAULT NULL COMMENT '删除状态（0-未删除，1已经删除）',
  `READ_TIME` datetime DEFAULT NULL COMMENT '阅读时间',
  `DELETE_TIME` datetime DEFAULT NULL COMMENT '删除的时间',
  PRIMARY KEY (`MSGID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message_one
-- ----------------------------

-- ----------------------------
-- Table structure for t_module
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `MODID` int(11) NOT NULL AUTO_INCREMENT,
  `MODULECODE` varchar(50) DEFAULT NULL COMMENT '模块CODE',
  `MODULENAME` varchar(50) DEFAULT NULL COMMENT '模块名称',
  `PARENTCODE` varchar(50) DEFAULT NULL COMMENT '父模块CODE',
  `MODULEURL` varchar(200) DEFAULT NULL COMMENT '模块对应的URL地址',
  PRIMARY KEY (`MODID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_module
-- ----------------------------

-- ----------------------------
-- Table structure for t_module_privilege
-- ----------------------------
DROP TABLE IF EXISTS `t_module_privilege`;
CREATE TABLE `t_module_privilege` (
  `MPID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MODULECODE` varchar(50) DEFAULT NULL COMMENT '模块CODE值',
  `PRICODE` varchar(100) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`MPID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_module_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for t_platform_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_platform_relation`;
CREATE TABLE `t_platform_relation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USERID` int(11) DEFAULT NULL COMMENT '兴趣金融平台用户ID',
  `PLATFORMID` int(11) DEFAULT NULL COMMENT '第三方平台ID',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  `STATUS` int(11) DEFAULT '0' COMMENT '开通状态（0-表示通过注册第三方账户开通，1-表示通过绑定第三方账户开通）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_platform_relation
-- ----------------------------
INSERT INTO `t_platform_relation` VALUES ('1', '31', '8', '2016-09-14 11:07:36', '0');
INSERT INTO `t_platform_relation` VALUES ('2', '31', '9', '2016-09-29 11:23:01', '0');
INSERT INTO `t_platform_relation` VALUES ('3', '13', '6', '2016-09-20 11:23:49', '0');
INSERT INTO `t_platform_relation` VALUES ('4', '13', '7', '2016-09-20 11:24:06', '0');

-- ----------------------------
-- Table structure for t_present_record
-- ----------------------------
DROP TABLE IF EXISTS `t_present_record`;
CREATE TABLE `t_present_record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` int(11) DEFAULT NULL COMMENT '提现的用户',
  `BANK_CARD_ID` int(11) DEFAULT NULL COMMENT '银行卡信息',
  `WITHDRAWALS_AMOUNT` int(11) DEFAULT NULL COMMENT '提现金额',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `DEAL_DATE` datetime DEFAULT NULL COMMENT '处理时间',
  `CREATEON` datetime DEFAULT NULL COMMENT '数据生成时间',
  `REMARK` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`),
  KEY `fk_t_present_record_t_bank_card_1` (`BANK_CARD_ID`),
  CONSTRAINT `fk_t_present_record_t_bank_card_1` FOREIGN KEY (`BANK_CARD_ID`) REFERENCES `t_bank_card` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_present_record
-- ----------------------------

-- ----------------------------
-- Table structure for t_privilege
-- ----------------------------
DROP TABLE IF EXISTS `t_privilege`;
CREATE TABLE `t_privilege` (
  `PRIID` int(11) NOT NULL AUTO_INCREMENT,
  `PRICODE` varchar(100) DEFAULT NULL COMMENT '权限CODE',
  `PRINAME` varchar(100) DEFAULT NULL COMMENT '权限名称',
  PRIMARY KEY (`PRIID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for t_province
-- ----------------------------
DROP TABLE IF EXISTS `t_province`;
CREATE TABLE `t_province` (
  `PID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  PRIMARY KEY (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_province
-- ----------------------------

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` int(11) DEFAULT NULL COMMENT '发表问题的用户ID',
  `IS_ANONYMOUS` int(11) DEFAULT NULL COMMENT '是否匿名（0-不是，1-是）',
  `TITLE` varchar(100) DEFAULT NULL COMMENT '问题的标题',
  `CONTENT` varchar(2000) DEFAULT NULL COMMENT '问题的内容',
  `CREATEDON` datetime DEFAULT NULL COMMENT '问题的提问时间',
  PRIMARY KEY (`ID`),
  KEY `fk_t_question_t_user_1` (`USERID`),
  CONSTRAINT `fk_t_question_t_user_1` FOREIGN KEY (`USERID`) REFERENCES `t_user` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_question
-- ----------------------------

-- ----------------------------
-- Table structure for t_question_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_question_answer`;
CREATE TABLE `t_question_answer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTIONID` int(11) NOT NULL COMMENT '问题的ID',
  `ANSWERID` int(11) NOT NULL COMMENT '回复的ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_question_answer
-- ----------------------------

-- ----------------------------
-- Table structure for t_reward_info
-- ----------------------------
DROP TABLE IF EXISTS `t_reward_info`;
CREATE TABLE `t_reward_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` int(11) DEFAULT NULL COMMENT '用户ID',
  `REWARD_TYPE` int(11) DEFAULT NULL COMMENT '奖励类型（数据字典，活动奖励，抽奖奖励，邀请好友奖励）',
  `REWARD_AMOUNT` int(11) DEFAULT NULL COMMENT '奖励金额',
  `DESCRIPTION` varchar(100) DEFAULT NULL COMMENT '奖励描述',
  `CREATEON` datetime DEFAULT NULL COMMENT '奖励时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_reward_info
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `ROLEID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `ROLECODE` varchar(50) DEFAULT NULL COMMENT '角色code值',
  `ROLENAME` varchar(50) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `t_role_privilege`;
CREATE TABLE `t_role_privilege` (
  `PRID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ROLECODE` varchar(50) DEFAULT NULL COMMENT '角色code值',
  `MPID` int(11) DEFAULT NULL COMMENT '权限ID主键',
  PRIMARY KEY (`PRID`),
  KEY `fk_t_user_privilege_t_module_privilege_1` (`MPID`),
  CONSTRAINT `fk_t_user_privilege_t_module_privilege_1` FOREIGN KEY (`MPID`) REFERENCES `t_module_privilege` (`MPID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for t_systemddl
-- ----------------------------
DROP TABLE IF EXISTS `t_systemddl`;
CREATE TABLE `t_systemddl` (
  `SEQ_ID` int(20) NOT NULL AUTO_INCREMENT,
  `KEYWORD` varchar(50) DEFAULT NULL COMMENT '查询关键字',
  `DDLCODE` int(100) DEFAULT NULL COMMENT '数据字典的code值',
  `DDLNAME` varchar(50) DEFAULT NULL COMMENT '数据字典的name值',
  PRIMARY KEY (`SEQ_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_systemddl
-- ----------------------------
INSERT INTO `t_systemddl` VALUES ('1', 'platform_category', '1', '新手专区');
INSERT INTO `t_systemddl` VALUES ('2', 'platform_category', '2', '精选专区');
INSERT INTO `t_systemddl` VALUES ('3', 'bearing_way', '1', '募集期计息');
INSERT INTO `t_systemddl` VALUES ('4', 'bearing_way', '2', '满标计息');
INSERT INTO `t_systemddl` VALUES ('5', 'bearing_way', '3', '次日计息');
INSERT INTO `t_systemddl` VALUES ('6', 'bearing_way', '4', '投资当日计息');
INSERT INTO `t_systemddl` VALUES ('7', 'guarantee_way', '1', '第三方保障');
INSERT INTO `t_systemddl` VALUES ('8', 'guarantee_way', '2', '本息保障');
INSERT INTO `t_systemddl` VALUES ('9', 'guarantee_way', '3', '全额本息保障');
INSERT INTO `t_systemddl` VALUES ('10', 'repayment_way', '1', '一次性还款');
INSERT INTO `t_systemddl` VALUES ('11', 'repayment_way', '2', '一次性还本付息');
INSERT INTO `t_systemddl` VALUES ('12', 'repayment_way', '3', '到期还本付息');
INSERT INTO `t_systemddl` VALUES ('13', 'platform_background', '1', '国资系');
INSERT INTO `t_systemddl` VALUES ('14', 'platform_background', '2', '民营系');
INSERT INTO `t_systemddl` VALUES ('15', 'platform_background', '3', '上市系');
INSERT INTO `t_systemddl` VALUES ('16', 'platform_background', '4', '风投系');
INSERT INTO `t_systemddl` VALUES ('17', 'gender', '1', '男');
INSERT INTO `t_systemddl` VALUES ('18', 'gender', '2', '女');
INSERT INTO `t_systemddl` VALUES ('19', 'gender', '3', '保密');
INSERT INTO `t_systemddl` VALUES ('20', 'politics', '1', '党员');
INSERT INTO `t_systemddl` VALUES ('21', 'politics', '2', '团员');
INSERT INTO `t_systemddl` VALUES ('22', 'politics', '3', '群众');
INSERT INTO `t_systemddl` VALUES ('23', 'marriages', '1', '未婚');
INSERT INTO `t_systemddl` VALUES ('24', 'marriages', '2', '已婚');
INSERT INTO `t_systemddl` VALUES ('25', 'marriages', '3', '同性恋');
INSERT INTO `t_systemddl` VALUES ('26', 'job_name', '1', 'Java开发工程师');
INSERT INTO `t_systemddl` VALUES ('27', 'job_name', '2', '运营推广');
INSERT INTO `t_systemddl` VALUES ('28', 'aducation', '1', '初中');
INSERT INTO `t_systemddl` VALUES ('29', 'aducation', '2', '高中');
INSERT INTO `t_systemddl` VALUES ('30', 'aducation', '3', '专科');
INSERT INTO `t_systemddl` VALUES ('31', 'aducation', '4', '本科');
INSERT INTO `t_systemddl` VALUES ('32', 'aducation', '5', '硕士');
INSERT INTO `t_systemddl` VALUES ('33', 'aducation', '6', '博士');
INSERT INTO `t_systemddl` VALUES ('34', 'aducation', '0', '其他');
INSERT INTO `t_systemddl` VALUES ('35', 'trans_status_success', '1', '成功');
INSERT INTO `t_systemddl` VALUES ('36', 'trans_status_failure', '2', '失败');
INSERT INTO `t_systemddl` VALUES ('37', 'trans_status_doing', '3', '进行中');
INSERT INTO `t_systemddl` VALUES ('38', 'trans_type_transfer', '1', '转账');
INSERT INTO `t_systemddl` VALUES ('39', 'trans_type_pay', '2', '充值');
INSERT INTO `t_systemddl` VALUES ('40', 'trans_type_whithdraw', '3', '提现');

-- ----------------------------
-- Table structure for t_transaction_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_transaction_detail`;
CREATE TABLE `t_transaction_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USERID` int(11) DEFAULT NULL COMMENT '用户ID',
  `AMOUNT` int(11) DEFAULT NULL COMMENT '交易金额',
  `AMOUNT_TYPE` int(11) DEFAULT NULL COMMENT '交易类型(0-支出，1-收入)',
  `TRANS_STATUS` int(11) DEFAULT NULL COMMENT '交易状态(0-成功，1-失败)',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_transaction_detail
-- ----------------------------
INSERT INTO `t_transaction_detail` VALUES ('1', '31', '45', '0', '0', '转账', '2016-09-19 21:29:48');
INSERT INTO `t_transaction_detail` VALUES ('2', '31', '15', '0', '0', '转账', '2016-09-17 21:29:28');
INSERT INTO `t_transaction_detail` VALUES ('3', '31', '25', '0', '0', '转账', '2016-09-16 21:29:07');
INSERT INTO `t_transaction_detail` VALUES ('4', '31', '40', '1', '0', '转账', '2016-09-07 21:28:37');
INSERT INTO `t_transaction_detail` VALUES ('5', '31', '20', '1', '0', '转账', '2016-09-06 21:27:38');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `USERID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USERNAME` varchar(255) NOT NULL COMMENT '用户登录名',
  `NICKNAME` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `HEADURLID` int(11) DEFAULT '1' COMMENT '用户头像ID',
  `REALNAME` varchar(250) DEFAULT NULL COMMENT '用户真实姓名',
  `PASSWORD` varchar(255) DEFAULT NULL COMMENT '用户登录密码',
  `IS_PAYPWD_STATUS` int(11) DEFAULT '0' COMMENT '是否已设置支付密码（0-未设置，1-已设置）',
  `PAYPASSWORD` varchar(255) DEFAULT NULL COMMENT '用户支付密码',
  `GENDER` int(11) DEFAULT NULL COMMENT '用户性别(数据字典)',
  `BIRTHDAY` datetime DEFAULT NULL COMMENT '用户生日',
  `ADDRESS` varchar(255) DEFAULT NULL COMMENT '地址',
  `SIGNATURE` varchar(255) DEFAULT NULL COMMENT '个性签名',
  `MARITALSTATUS` int(11) DEFAULT NULL COMMENT '婚姻状态(数据字典)',
  `EDUCATION` varchar(11) DEFAULT NULL COMMENT '用户的学历(数据字典)',
  `SALARY` int(11) DEFAULT NULL COMMENT '月薪(数据字典)',
  `OCCUPATION` int(11) DEFAULT NULL COMMENT '职业(数据字典)',
  `IS_INVERSTMENT_STATUS` int(11) DEFAULT '0' COMMENT '用户是否投资（0-未投资，1-已投资）',
  `IS_TEL_STATUS` int(11) DEFAULT '0' COMMENT '是否手机认证（0-未认证，1-已认证）',
  `TELLPHONE` varchar(11) DEFAULT NULL COMMENT '绑定的手机号码',
  `IS_EMAIL_STATUS` int(11) DEFAULT '0' COMMENT '是否电子邮件认证（0-未认证，1-已认证）',
  `EMAIL` varchar(255) DEFAULT NULL COMMENT '绑定的邮箱',
  `IS_AUTH_STATUS` int(11) DEFAULT '0' COMMENT '是否实名认证（0-未认证，1-已认证）',
  `IS_BIND_BANKCARD` int(11) DEFAULT '0' COMMENT '是否绑定银行卡【0】未绑定，【1】已绑定',
  `TOTALACCOUNT` decimal(10,2) DEFAULT '0.00' COMMENT '账号总额',
  `AVAILABLEBALANCE` decimal(10,2) DEFAULT '0.00' COMMENT '可用余额',
  `TOTALBENEFIT` decimal(10,2) DEFAULT '0.00' COMMENT '总收益',
  `PLATFORMBENEFIT` decimal(10,2) DEFAULT '0.00' COMMENT '平台收益',
  `FREEZEREDATE` decimal(10,2) DEFAULT '0.00' COMMENT '返利冻结',
  `FREEZEWITHDRAWALS` decimal(10,2) DEFAULT '0.00' COMMENT '提现冻结',
  `TOTALINVESTMENT` decimal(10,2) DEFAULT NULL COMMENT '投资总额',
  `CREATETIME` datetime DEFAULT NULL COMMENT '用户创建时间',
  `INVITECODE` varchar(255) DEFAULT NULL COMMENT '邀请码',
  `INTEGRAL` int(11) DEFAULT '0' COMMENT '用户积分',
  PRIMARY KEY (`USERID`),
  KEY `fk_t_user_t_img_1` (`HEADURLID`),
  CONSTRAINT `fk_t_user_t_img_1` FOREIGN KEY (`HEADURLID`) REFERENCES `t_img` (`IMGID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('13', '15017916946', '王先生', '1', '王五', 'e10adc3949ba59abbe56e057f20f883e', '0', null, '1', '2016-09-12 13:47:05', '深圳南山区', '签名1', '1', '4', '5000', '1', '0', '0', '13645268452', '0', '123456@qq.com', '0', '1', '1060.00', '0.00', '0.00', '0.00', '0.00', '0.00', '50000.00', '2016-08-16 11:38:02', '85865468', '60');
INSERT INTO `t_user` VALUES ('15', '13554222770', '李先生', '1', '李四', 'e10adc3949ba59abbe56e057f20f883e', '1', 'e10adc3949ba59abbe56e057f20f883e', '1', '2016-09-05 13:47:11', '深圳罗湖区', '签名2', '1', '4', '6000', '2', '0', '0', '18124016607', '0', '23456@qq.com', '0', '0', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '5500.00', '2016-08-06 11:38:07', '85865486', '20');
INSERT INTO `t_user` VALUES ('31', '18124016607', '张先生', '1', '张三', 'e10adc3949ba59abbe56e057f20f883e', '1', 'e10adc3949ba59abbe56e057f20f883e', '1', '2016-09-14 13:47:14', '深圳福田区', '签名3', '1', '4', '7000', '1', '0', '1', '18124016607', '0', '548264@qq.com', '0', '0', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '2500.00', '2016-08-29 16:24:44', '84204956', '40');

-- ----------------------------
-- Table structure for t_user_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_user_activity`;
CREATE TABLE `t_user_activity` (
  `UAID` int(11) NOT NULL,
  `USERID` int(11) DEFAULT NULL,
  `ACID` int(11) DEFAULT NULL,
  `CREATEDON` datetime DEFAULT NULL,
  PRIMARY KEY (`UAID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_activity
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_bid
-- ----------------------------
DROP TABLE IF EXISTS `t_user_bid`;
CREATE TABLE `t_user_bid` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` int(11) DEFAULT NULL COMMENT '用户的ID主键',
  `BIDID` int(11) DEFAULT NULL COMMENT '投标的项目ID',
  `PLATFORMID` int(11) DEFAULT NULL COMMENT '所属平台的ID',
  `ORDER_NUMBER` varchar(250) DEFAULT NULL COMMENT '订单号',
  `INVESTMENT_AMOUNT` decimal(11,2) DEFAULT NULL COMMENT '投资金额',
  `INTEREST_RATE_COUPON` int(11) DEFAULT NULL COMMENT '加息券',
  `SELF_PLATFORM_REVENUE` decimal(11,2) DEFAULT NULL COMMENT '本平台收益（投资金额*生菜年化率，包括加息券）',
  `PLATFORM_REVENUE` decimal(11,2) DEFAULT '0.00' COMMENT '投资平台的返现金额',
  `CREATEDON` datetime DEFAULT NULL COMMENT '创建时间',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态（冻结，返利，跳转）',
  `FREEZING_TIME` datetime DEFAULT NULL COMMENT '冻结时间',
  `RETURN_TIME` datetime DEFAULT NULL COMMENT '返利时间',
  PRIMARY KEY (`ID`),
  KEY `fk_t_user_ipf_t_ip_project_1` (`BIDID`),
  CONSTRAINT `fk_t_user_ipf_t_ip_project_1` FOREIGN KEY (`BIDID`) REFERENCES `t_bid` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_bid
-- ----------------------------
INSERT INTO `t_user_bid` VALUES ('13', '13', '8', '10', null, '9000.00', null, '360.00', '900.00', '2016-09-20 14:23:40', null, null, null);
INSERT INTO `t_user_bid` VALUES ('14', '13', '9', '12', null, '3000.00', null, '60.00', '330.00', '2016-09-20 14:57:48', null, null, null);
INSERT INTO `t_user_bid` VALUES ('15', '13', '14', '14', null, '20000.00', null, '400.00', '2400.00', '2016-09-20 14:57:58', null, null, null);
INSERT INTO `t_user_bid` VALUES ('16', '13', '7', '15', null, '2000.00', null, '60.00', '240.00', '2016-09-20 16:33:54', null, null, null);
INSERT INTO `t_user_bid` VALUES ('17', '13', '7', '8', null, '9000.00', null, '180.00', '1080.00', '2016-09-21 11:41:04', null, null, null);

-- ----------------------------
-- Table structure for t_user_commsg
-- ----------------------------
DROP TABLE IF EXISTS `t_user_commsg`;
CREATE TABLE `t_user_commsg` (
  `UCID` int(11) NOT NULL,
  `USERID` int(11) DEFAULT NULL,
  `MSGID` int(11) DEFAULT NULL,
  PRIMARY KEY (`UCID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_commsg
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_department
-- ----------------------------
DROP TABLE IF EXISTS `t_user_department`;
CREATE TABLE `t_user_department` (
  `ID` int(11) DEFAULT NULL,
  `USERID` int(11) DEFAULT NULL,
  `DEPARTID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_department
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_integral
-- ----------------------------
DROP TABLE IF EXISTS `t_user_integral`;
CREATE TABLE `t_user_integral` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '积分ID',
  `USERID` int(11) DEFAULT NULL COMMENT '用户ID',
  `SCORE` int(11) DEFAULT '0' COMMENT '积分收支',
  `SCORE_TYPE` int(11) DEFAULT NULL COMMENT '积分收支标识（0-支出，1-收入）',
  `SOURCE` varchar(255) DEFAULT NULL COMMENT '积分来源',
  `AVAILABLE_INTEGRAL` int(11) DEFAULT '0' COMMENT '可用积分',
  `TOTAL_INTEGRAL` int(11) DEFAULT '0' COMMENT '总积分',
  `CREATETIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_integral
-- ----------------------------
INSERT INTO `t_user_integral` VALUES ('1', '31', '20', '1', '用户注册', '20', '20', '2016-08-29 16:24:44');
INSERT INTO `t_user_integral` VALUES ('2', '13', '20', '1', '用户注册', '20', '20', '2016-08-16 11:38:02');
INSERT INTO `t_user_integral` VALUES ('3', '31', '50', '1', '加积分', '70', '70', '2016-09-13 15:51:27');
INSERT INTO `t_user_integral` VALUES ('4', '31', '15', '1', '加积分', '75', '85', '2016-09-18 15:52:02');
INSERT INTO `t_user_integral` VALUES ('5', '31', '25', '0', '减积分', '60', '60', '2016-09-19 15:52:46');
INSERT INTO `t_user_integral` VALUES ('6', '13', '15', '1', '加积分', '35', '35', '2016-09-11 15:53:19');
INSERT INTO `t_user_integral` VALUES ('7', '13', '45', '1', '加积分', '80', '80', '2016-09-18 15:54:50');
INSERT INTO `t_user_integral` VALUES ('8', '13', '40', '0', '减积分', '40', '40', '2016-09-19 15:55:16');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL,
  `USERID` int(11) NOT NULL,
  `ROLEID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_u_role
-- ----------------------------
DROP TABLE IF EXISTS `t_u_role`;
CREATE TABLE `t_u_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` int(11) NOT NULL COMMENT '用户ID',
  `ROLEID` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`ID`),
  KEY `fk_Table 1_t_user_1` (`USERID`),
  CONSTRAINT `fk_Table 1_t_user_1` FOREIGN KEY (`USERID`) REFERENCES `t_user` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_u_role
-- ----------------------------
