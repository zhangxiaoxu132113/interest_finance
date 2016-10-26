CREATE TABLE `t_user` (
`USERID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`USERNAME` varchar(255) NOT NULL COMMENT '用户登录名',
`NICKNAME` varchar(255) NULL COMMENT '用户昵称',
`HEADURLID` int(11) NULL COMMENT '用户头像ID',
`REALNAME` varchar(250) NULL COMMENT '用户真实姓名',
`PASSWORD` varchar(255) NULL COMMENT '用户登录密码',
`GENDER` int(11) NULL COMMENT '用户性别(数据字典)',
`BIRTHDAY` datetime NULL COMMENT '用户生日',
`ADDRESS` varchar(255) NULL COMMENT '地址',
`SIGNATURE` varchar(255) NULL COMMENT '个性签名',
`MARITALSTATUS` int(11) NULL COMMENT '婚姻状态(数据字典)',
`EDUCATION` varchar(11) NULL COMMENT '用户的学历(数据字典)',
`SALARY` int(11) NULL COMMENT '月薪(数据字典)',
`OCCUPATION` int(11) NULL COMMENT '职业(数据字典)',
`IS_INVERSTMENT_STATUS` int(11) NULL COMMENT '用户是否投资（0-未投资，1-已投资）',
`IS_TEL_STATUS` int(11) NULL COMMENT '是否手机认证（0-未认证，1-已认证）',
`IS_EMAIL_STATUS` int(11) NULL COMMENT '是否电子邮件认证（0-未认证，1-已认证）',
`IS_AUTH_STATUS` int(11) NULL COMMENT '是否实名认证（0-未认证，1-已认证）',
`TOTALACCOUNT` decimal(10,2) NULL COMMENT '账号总额',
`AVAILABLEBALANCE` decimal(10,2) NULL COMMENT '可用余额',
`TOTALBENEFIT` decimal(10,2) NULL COMMENT '总收益',
`PLATFORMBENEFIT` decimal(10,2) NULL COMMENT '平台收益',
`FREEZEREDATE` decimal(10,2) NULL COMMENT '返利冻结',
`FREEZEWITHDRAWALS` decimal(10,2) NULL COMMENT '提现冻结',
`TOTALINVESTMENT` decimal(10,2) NULL COMMENT '投资总额',
PRIMARY KEY (`USERID`) 
);

CREATE TABLE `t_role` (
`ROLEID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
`ROLECODE` varchar(50) NULL COMMENT '角色code值',
`ROLENAME` varchar(50) NULL COMMENT '角色名称',
PRIMARY KEY (`ROLEID`) 
);

CREATE TABLE `t_user_role` (
`id` int NOT NULL,
`USERID` int NOT NULL,
`ROLEID` int NOT NULL
);

CREATE TABLE `t_u_role` (
`ID` int(11) NOT NULL AUTO_INCREMENT,
`USERID` int(11) NOT NULL COMMENT '用户ID',
`ROLEID` int(11) NULL COMMENT '角色ID',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_module` (
`MODID` int(11) NOT NULL AUTO_INCREMENT,
`MODULECODE` varchar(50) NULL COMMENT '模块CODE',
`MODULENAME` varchar(50) NULL COMMENT '模块名称',
`PARENTCODE` varchar(50) NULL COMMENT '父模块CODE',
`MODULEURL` varchar(200) NULL COMMENT '模块对应的URL地址',
PRIMARY KEY (`MODID`) 
);

CREATE TABLE `t_privilege` (
`PRIID` int(11) NOT NULL AUTO_INCREMENT,
`PRICODE` varchar(100) NULL COMMENT '权限CODE',
`PRINAME` varchar(100) NULL COMMENT '权限名称',
PRIMARY KEY (`PRIID`) 
);

CREATE TABLE `t_module_privilege` (
`MPID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`MODULECODE` varchar(50) NULL COMMENT '模块CODE值',
`PRICODE` varchar(100) NULL COMMENT '权限ID',
PRIMARY KEY (`MPID`) 
);

CREATE TABLE `t_role_privilege` (
`PRID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`ROLECODE` varchar(50) NULL COMMENT '角色code值',
`MPID` int(11) NULL COMMENT '权限ID主键',
PRIMARY KEY (`PRID`) 
);

CREATE TABLE `t_login_log` (
`ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`USERID` int(11) NULL COMMENT '用户ID',
`LOGINTIME` datetime NULL COMMENT '当前登录时间',
`LASTTIME` datetime NULL COMMENT '上次登录时间',
`CONTINUElOGINCNT` int NULL COMMENT '连续登录次数',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_img` (
`IMGID` int(11) NOT NULL AUTO_INCREMENT,
`IMGURL` varchar(255) CHARACTER SET utf8 NULL COMMENT '图片地址',
PRIMARY KEY (`IMGID`) 
);

CREATE TABLE `t_article` (
`ARID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`TITLE` varchar(255) NULL COMMENT '文章标题',
`SUMMARY` varchar(1000) NULL COMMENT '文章的概要',
`CONTENT` varchar(3000) NULL COMMENT '文章的内容',
`HITS` int(11) NULL COMMENT '文章的点击量',
`CREATEUSERID` int(11) NULL COMMENT '文章的创建者',
`ARTICLE_MODULE` int(11) NULL COMMENT '文章的所属模块',
`CREATEDON` datetime NULL COMMENT '文章的发表时间',
PRIMARY KEY (`ARID`) 
);

CREATE TABLE `t_activity` (
`ID` int(11) NOT NULL COMMENT '主键',
`TITLE` varchar(255) NULL COMMENT '活动名称',
`CONTENT` varchar(3000) NULL COMMENT '活动内容',
`DESCRIPTION` varchar(3000) NULL COMMENT '活动的规则',
`ARTICLE_MODULE` int(11) NULL COMMENT '所属的模块',
`CREATEUSERID` int(11) NULL COMMENT '活动的创建者',
`BEGINTIME` datetime NULL COMMENT '活动开始时间',
`ENDTIME` datetime NULL COMMENT '活动结束时间',
`CREATEDON` datetime NULL COMMENT '表数据创建时间',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_investmentPlatform` (
`ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`P_NAME` varchar(250) NULL COMMENT '平台的名称',
`C_NAME` varchar(250) NULL COMMENT '平台所属公司的名称',
`REGISTERED_CAPITAL` int(20) NULL COMMENT '注册资金',
`C_ADDRESS` varchar(255) NULL COMMENT '公司地址',
`LOCAL_AREA` int(11) NULL COMMENT '所在地区(数据字典)',
`SCORE` int(11) NULL COMMENT '用户评分',
`LEGAL_REPERSENTATIVE` varchar(250) NULL COMMENT '法人代表',
`UPTIME` datetime NULL COMMENT '上线时间',
`PLATFORM_INTRODUCTION` varchar(3000) NULL COMMENT '平台介绍',
`RECOMMENDED_REASON` varchar(3000) NULL COMMENT '推荐理由',
`WIND_CONTROL_SITUATION` varchar(3000) NULL COMMENT '风控情况',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_user_bid` (
`ID` int(11) NOT NULL AUTO_INCREMENT,
`USERID` int(11) NULL,
`BIDID` int(11) NULL COMMENT '投标的项目ID',
`ORDER_NUMBER` varchar(250) NULL COMMENT '订单号',
`INVESTMENT_AMOUNT` int(11) NULL COMMENT '投资金额',
`INTEREST_RATE_COUPON` int(11) NULL COMMENT '加息券',
`PLATFORM_REVENUE` int(11) NULL COMMENT '本平台收益（投资金额*生菜年化率，包括加息券）',
`CREATEDON` datetime NULL COMMENT '创建时间',
`STATUS` int(11) NULL COMMENT '状态（冻结，返利，跳转）',
`FREEZING_TIME` datetime NULL COMMENT '冻结时间',
`RETURN_TIME` datetime NULL COMMENT '返利时间',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_systemddl` (
`SEQ_ID` int(20) NOT NULL,
`KEYWORD` varchar(50) NULL COMMENT '查询关键字',
`DDLCODE` int(100) NULL COMMENT '数据字典的code值',
`DDLNAME` varchar(50) NULL COMMENT '数据字典的name值',
PRIMARY KEY (`SEQ_ID`) 
);

CREATE TABLE `t_user_activity` (
`UAID` int(11) NOT NULL,
`USERID` int(11) NULL,
`ACID` int(11) NULL,
`CREATEDON` datetime NULL,
PRIMARY KEY (`UAID`) 
);

CREATE TABLE `t_commsg` (
`MSGID` int(11) NOT NULL,
`TITLE` varchar(255) NULL,
`CONTENT` varchar(2000) NULL,
`CREATEDON` datetime NULL,
`CREATEUSERID` int(11) NULL,
PRIMARY KEY (`MSGID`) 
);

CREATE TABLE `t_user_commsg` (
`UCID` int(11) NOT NULL,
`USERID` int(11) NULL,
`MSGID` int(11) NULL,
PRIMARY KEY (`UCID`) 
);

CREATE TABLE `t_log` (
`LOGID` int(11) NOT NULL,
`USERID` int(11) NULL,
PRIMARY KEY (`LOGID`) 
);

CREATE TABLE `t_department` (
`DEPARTMEN_ID` int(11) NOT NULL COMMENT '主键',
`DEPARTMEN_NAME` varchar(255) NULL COMMENT '部门名称',
`DEPARTMEN_HEAD` int(11) NULL COMMENT '部门负责人（外键）',
PRIMARY KEY (`DEPARTMEN_ID`) 
);

CREATE TABLE `t_user_department` (
`ID` int NULL,
`USERID` int NULL,
`DEPARTID` int NULL
);

CREATE TABLE `t_empinfo` (
`ID` int(11) NOT NULL COMMENT '主键',
`EMPLOYEE _ID` int(11) NOT NULL COMMENT '员工编号',
`USERNAME` varchar(250) NOT NULL COMMENT '昵称/登录名',
`PASSWORD` varchar(250) NOT NULL COMMENT '用户密码',
`EMPLOYEE_NAME` varchar(250) NULL COMMENT '员工姓名',
`DEPARTMEN_ID` int(11) NULL COMMENT '所属部门ID',
`GENDER` int(11) NULL COMMENT '性别',
`BRITHDAY` datetime NULL COMMENT '出生日期',
`POLITICS_STATAS` int(11) NULL COMMENT '政治面貌',
`MARRIAGE` int(11) NULL COMMENT '婚姻状态',
`ADRRESS` varchar(250) NULL COMMENT '家庭地址',
`EMAL` varchar(250) NULL COMMENT '电子邮件',
`PHONE` int(20) NULL COMMENT '电话号码',
`ID_NUMBER` int(30) NULL COMMENT '身份证',
`CREATEDON` datetime NULL COMMENT '用户的创建时间',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_friends_invitation` (
`ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`USERID` int(11) NULL COMMENT '发起邀请的用户ID',
`FRIENDID` int(11) NULL COMMENT '受邀请的用户ID',
`INVIATION_WAY` int(11) NULL COMMENT '邀请方式',
`CREATEDON` datetime NULL COMMENT '用户邀请的时间',
`INVITATION_CODE` varchar(100) NULL COMMENT '邀请码',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `b_web_manager` (
`ID` int(11) NOT NULL,
`PICID` int(11) NULL,
`DESCRIPTION` varchar(255) NULL,
`URL` varchar(255) NULL,
`SORTORDER` int(11) NULL,
`MANAGER_MODULE` int(11) NULL COMMENT '(外键数据字典的ddlcode)对应的每一条信息所属的网站管理模块，such，友情链接，合作机构',
`WEB_KEY` varchar(255) NULL,
`WEB_NAME` varchar(500) NULL,
`INDEX_TITLE` varchar(500) NULL,
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_article_module` (
`AMID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`ART_CODE` varchar(250) NULL COMMENT '文章的CODE',
`ART_NAME` varchar(250) NULL COMMENT '文章模块名称',
`PARTENT_MODULE` int(11) NULL COMMENT '父级模块',
`SORTORDER` int(11) NULL COMMENT '排序',
`REMARK` varchar(250) NULL COMMENT '备注',
PRIMARY KEY (`AMID`) 
);

CREATE TABLE `t_message_global` (
`MSGID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`SENDER_ID` int(11) NOT NULL COMMENT '发送消息人ID',
`MESSAGE_TITLE` varchar(255) CHARACTER SET utf8 NULL COMMENT '消息的标题',
`MESSAGE_CONTENT` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '消息内容',
`MESSAGE_TYPE` int(11) NULL COMMENT '消息类型(用户类型，用户组类型，全局类型)',
`MESSAGE_PRIORITY` int(11) NULL COMMENT '消息等级',
`SEND_TIME` datetime NULL COMMENT '消息发送时间',
PRIMARY KEY (`MSGID`) 
);

CREATE TABLE `t_message_log` (
`ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`MESSAGE_ID` int(11) NOT NULL COMMENT '消息ID',
`USER_ID` int(11) NOT NULL COMMENT '用户ID',
`READ_STATUS` int(11) NULL COMMENT '阅读状态',
`DELETE_STATUS` int(11) NULL COMMENT '删除状态',
`READ_TIME` datetime NULL COMMENT '阅读时间',
`DELETE_TIME` datetime NULL COMMENT '删除时间',
`IS_STAR` varchar(255) NULL COMMENT '星级标记',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_message_one` (
`MSGID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`USERID` int(11) NULL COMMENT '接受人的ID',
`SENDERID` int(11) NOT NULL COMMENT '发送消息人ID',
`MESSAGE_TITLE` varchar(255) CHARACTER SET utf8 NULL COMMENT '消息的标题',
`MESSAGE_CONTENT` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '消息内容',
`MESSAGE_TYPE` int(11) NULL COMMENT '消息类型(用户类型，用户组类型，全局类型)',
`MESSAGE_PRIORITY` int(11) NULL COMMENT '消息等级',
`SEND_TIME` datetime NULL COMMENT '消息发送时间',
`READ_STATUS` int(11) NULL COMMENT '阅读状态（0-还没有阅读，1-已经阅读）',
`DELETE_STATUS` int(11) NULL COMMENT '删除状态（0-未删除，1已经删除）',
`READ_TIME` datetime NULL COMMENT '阅读时间',
`DELETE_TIME` datetime NULL COMMENT '删除的时间',
PRIMARY KEY (`MSGID`) 
);

CREATE TABLE `t_question` (
`ID` int(11) NOT NULL AUTO_INCREMENT,
`USERID` int(11) NULL COMMENT '发表问题的用户ID',
`IS_ANONYMOUS` int(11) NULL COMMENT '是否匿名（0-不是，1-是）',
`TITLE` varchar(100) NULL COMMENT '问题的标题',
`CONTENT` varchar(2000) NULL COMMENT '问题的内容',
`CREATEDON` datetime NULL COMMENT '问题的提问时间',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_answer` (
`ID` int(11) NOT NULL AUTO_INCREMENT,
`QUESTION_ID` int(11) NULL COMMENT '问题ID',
`EMPLOYEE _ID` int(11) NOT NULL COMMENT '回复问题的员工ID',
`CONTENT` varchar(2000) NULL COMMENT '回复的内容',
`SCORE_LEVEL_ONE` int(11) NULL COMMENT '问题的满意度one为满意',
`SCORE_LEVEL_TWO` int(11) NULL COMMENT '问题的满意度two一般',
`SCORE_LEVEL_THREE` int(11) NULL COMMENT '问题的满意度three不满意',
`CREATEDON` datetime NULL COMMENT '回复的时间',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_question_answer` (
`ID` int(11) NOT NULL AUTO_INCREMENT,
`QUESTIONID` int(11) NOT NULL COMMENT '问题的ID',
`ANSWERID` int(11) NOT NULL COMMENT '回复的ID',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_bid` (
`ID` int(11) NOT NULL AUTO_INCREMENT,
`PLATFORMID` int(11) NULL COMMENT '所属平台的ID',
`NAME` varchar(255) NULL COMMENT '标的名称',
`DESCRIPTION` varchar(2000) NULL COMMENT '标的描述信',
`TOTALCAPITAL` int(11) NULL COMMENT '标的总额',
`QUOTA` int(11) NULL COMMENT '投标限额',
`ANNUALRATE` int(11) NULL COMMENT '年化率（项目收益）',
`SELF_ANNUALRATE` int(11) NULL COMMENT '平台提供的年化率',
`TERM` int(11) NULL COMMENT '期限（应该使用什么数据呢？）',
`STARTAMOUNT` int(11) NULL COMMENT '起投金额',
`REPAYMENT_WAY` int(11) NULL COMMENT '还款方式',
`BEARING_WAY` int(11) NULL COMMENT '计息方式',
`SAFEGUARD_WAY` int(11) NULL COMMENT '保障方式',
`MODULE` int(11) NULL COMMENT '所属模块（新手菜地，天天收菜）',
`CREATEON` datetime NULL COMMENT '数据生成时间',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_city` (
`CID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`PID` inT(11) NULL COMMENT '省对应的主键',
PRIMARY KEY (`CID`) 
);

CREATE TABLE `t_province` (
`PID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
PRIMARY KEY (`PID`) 
);

CREATE TABLE `t_reward_info` (
`ID` int(11) NOT NULL AUTO_INCREMENT,
`USERID` int(11) NULL COMMENT '用户ID',
`REWARD_TYPE` int(11) NULL COMMENT '奖励类型（数据字典，活动奖励，抽奖奖励，邀请好友奖励）',
`REWARD_AMOUNT` int(11) NULL COMMENT '奖励金额',
`DESCRIPTION` varchar(100) NULL COMMENT '奖励描述',
`CREATEON` datetime NULL COMMENT '奖励时间',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_present_record` (
`ID` int(11) NOT NULL AUTO_INCREMENT,
`USERID` int(11) NULL COMMENT '提现的用户',
`BANK_CARD_ID` int(11) NULL COMMENT '银行卡信息',
`WITHDRAWALS_AMOUNT` int(11) NULL COMMENT '提现金额',
`STATUS` int(11) NULL COMMENT '状态',
`DEAL_DATE` datetime NULL COMMENT '处理时间',
`CREATEON` datetime NULL COMMENT '数据生成时间',
`REMARK` varchar(100) NULL COMMENT '备注',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_bank_card` (
`ID` int(11) NOT NULL AUTO_INCREMENT,
`ACCOUNT_NAME` varchar(100) NULL COMMENT '开户名',
`CARD_NO` int(20) NULL COMMENT '银行卡号',
`BANK_CODE` int(11) NULL COMMENT '银行CODE值',
`BANK_BRANCH` varchar(100) NULL COMMENT '开户支行',
PRIMARY KEY (`ID`) 
);

CREATE TABLE `t_interest_rate_coupon` (
`ID` int(11) NOT NULL AUTO_INCREMENT,
PRIMARY KEY (`ID`) 
);


ALTER TABLE `t_user_role` ADD CONSTRAINT `fk_t_user_role_t_user_role_1` FOREIGN KEY (`ROLEID`) REFERENCES `t_user_role` (`ROLEID`);
ALTER TABLE `t_u_role` ADD CONSTRAINT `fk_Table 1_t_user_1` FOREIGN KEY (`USERID`) REFERENCES `t_user` (`USERID`);
ALTER TABLE `t_role` ADD CONSTRAINT `fk_t_role_Table 1_1` FOREIGN KEY (`ROLEID`) REFERENCES `t_u_role` (`ROLEID`);
ALTER TABLE `t_module` ADD CONSTRAINT `fk_t_module_t_module_privilage_1` FOREIGN KEY (`MODULECODE`) REFERENCES `t_module_privilege` (`MODULECODE`);
ALTER TABLE `t_privilege` ADD CONSTRAINT `fk_t_privilage_t_module_privilage_1` FOREIGN KEY (`PRICODE`) REFERENCES `t_module_privilege` (`PRICODE`);
ALTER TABLE `t_role` ADD CONSTRAINT `fk_t_role_t_user_privilege_1` FOREIGN KEY (`ROLECODE`) REFERENCES `t_role_privilege` (`ROLECODE`);
ALTER TABLE `t_role_privilege` ADD CONSTRAINT `fk_t_user_privilege_t_module_privilege_1` FOREIGN KEY (`MPID`) REFERENCES `t_module_privilege` (`MPID`);
ALTER TABLE `t_user` ADD CONSTRAINT `fk_t_user_t_login_log_1` FOREIGN KEY (`USERID`) REFERENCES `t_login_log` (`USERID`);
ALTER TABLE `t_user` ADD CONSTRAINT `fk_t_user_t_img_1` FOREIGN KEY (`HEADURLID`) REFERENCES `t_img` (`IMGID`);
ALTER TABLE `t_user` ADD CONSTRAINT `fk_t_user_t_user_ipf_1` FOREIGN KEY (`USERID`) REFERENCES `t_user_bid` (`USERID`);
ALTER TABLE `t_user` ADD CONSTRAINT `fk_t_user_t_user_activity_1` FOREIGN KEY (`USERID`) REFERENCES `t_user_activity` (`USERID`);
ALTER TABLE `t_activity` ADD CONSTRAINT `fk_t_activity_t_user_activity_1` FOREIGN KEY (`ID`) REFERENCES `t_user_activity` (`ACID`);
ALTER TABLE `t_user` ADD CONSTRAINT `fk_t_user_t_user_commsg_1` FOREIGN KEY (`USERID`) REFERENCES `t_user_commsg` (`USERID`);
ALTER TABLE `t_commsg` ADD CONSTRAINT `fk_t_commsg_t_user_commsg_1` FOREIGN KEY (`MSGID`) REFERENCES `t_user_commsg` (`MSGID`);
ALTER TABLE `t_user` ADD CONSTRAINT `fk_t_user_t_log_1` FOREIGN KEY (`USERID`) REFERENCES `t_log` (`USERID`);
ALTER TABLE `t_department` ADD CONSTRAINT `fk_t_department_t_user_department_1` FOREIGN KEY (`DEPARTMEN_ID`) REFERENCES `t_user_department` (`DEPARTID`);
ALTER TABLE `t_empinfo` ADD CONSTRAINT `fk_ t_empinfo_t_user_department_1` FOREIGN KEY (`ID`) REFERENCES `t_user_department` (`USERID`);
ALTER TABLE `t_user` ADD CONSTRAINT `fk_t_user_t_friends_invitation_1` FOREIGN KEY (`USERID`) REFERENCES `t_friends_invitation` (`USERID`);
ALTER TABLE `t_user` ADD CONSTRAINT `fk_t_user_t_friends_invitation_2` FOREIGN KEY (`USERID`) REFERENCES `t_friends_invitation` (`FRIENDID`);
ALTER TABLE `t_img` ADD CONSTRAINT `fk_t_img_b_web_manager_1` FOREIGN KEY (`IMGID`) REFERENCES `b_web_manager` (`PICID`);
ALTER TABLE `t_department` ADD CONSTRAINT `fk_t_department_ t_empinfo_1` FOREIGN KEY (`DEPARTMEN_ID`) REFERENCES `t_empinfo` (`DEPARTMEN_ID`);
ALTER TABLE `t_article` ADD CONSTRAINT `fk_t_article_ t_empinfo_1` FOREIGN KEY (`CREATEUSERID`) REFERENCES `t_empinfo` (`ID`);
ALTER TABLE `t_empinfo` ADD CONSTRAINT `fk_ t_empinfo_t_activity_1` FOREIGN KEY (`ID`) REFERENCES `t_activity` (`CREATEUSERID`);
ALTER TABLE `t_article` ADD CONSTRAINT `fk_t_article_t_article_module_1` FOREIGN KEY (`ARTICLE_MODULE`) REFERENCES `t_article_module` (`AMID`);
ALTER TABLE `t_message_global` ADD CONSTRAINT `fk_t_message_global_t_message_log_1` FOREIGN KEY (`MSGID`) REFERENCES `t_message_log` (`MESSAGE_ID`);
ALTER TABLE `t_user` ADD CONSTRAINT `fk_t_user_t_message_log_1` FOREIGN KEY (`USERID`) REFERENCES `t_message_log` (`USER_ID`);
ALTER TABLE `t_question` ADD CONSTRAINT `fk_t_question_t_user_1` FOREIGN KEY (`USERID`) REFERENCES `t_user` (`USERID`);
ALTER TABLE `t_answer` ADD CONSTRAINT `fk_t_answer_t_empinfo_1` FOREIGN KEY (`EMPLOYEE _ID`) REFERENCES `t_empinfo` (`EMPLOYEE _ID`);
ALTER TABLE `t_question` ADD CONSTRAINT `fk_t_question_t_question_answer_1` FOREIGN KEY (`ID`) REFERENCES `t_question_answer` (`QUESTIONID`);
ALTER TABLE `t_answer` ADD CONSTRAINT `fk_t_answer_t_question_answer_1` FOREIGN KEY (`ID`) REFERENCES `t_question_answer` (`ANSWERID`);
ALTER TABLE `t_bid` ADD CONSTRAINT `fk_t_ip_project_t_investmentPlatform_1` FOREIGN KEY (`PLATFORMID`) REFERENCES `t_investmentPlatform` (`ID`);
ALTER TABLE `t_user_bid` ADD CONSTRAINT `fk_t_user_ipf_t_ip_project_1` FOREIGN KEY (`BIDID`) REFERENCES `t_bid` (`ID`);
ALTER TABLE `t_user` ADD CONSTRAINT `fk_t_user_t_message_one_1` FOREIGN KEY (`USERID`) REFERENCES `t_message_one` (`USERID`);
ALTER TABLE `t_province` ADD CONSTRAINT `fk_t_province_t_city_1` FOREIGN KEY (`PID`) REFERENCES `t_city` (`PID`);
ALTER TABLE `t_question` ADD CONSTRAINT `fk_t_question_t_answer_1` FOREIGN KEY (`ID`) REFERENCES `t_answer` (`QUESTION_ID`);
ALTER TABLE `t_user` ADD CONSTRAINT `fk_t_user_t_reward_info_1` FOREIGN KEY (`USERID`) REFERENCES `t_reward_info` (`USERID`);
ALTER TABLE `t_present_record` ADD CONSTRAINT `fk_t_present_record_t_bank_card_1` FOREIGN KEY (`BANK_CARD_ID`) REFERENCES `t_bank_card` (`ID`);
ALTER TABLE `t_user` ADD CONSTRAINT `fk_t_user_t_present_record_1` FOREIGN KEY (`USERID`) REFERENCES `t_present_record` (`USERID`);

