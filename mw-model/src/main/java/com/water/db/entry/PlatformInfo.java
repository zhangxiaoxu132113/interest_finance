package com.water.db.entry;

import java.sql.Date;

/**
 * Created by mrwater on 16/8/30.
 */
public class PlatformInfo implements  java.io.Serializable {

    private int id;
    /**
     * 平台名称
     */
    private String pName;

    /**
     * 公司名称
     */
    private String cName;

    /**
     * 平台logo
     */
    private String logoImg;

    /**
     * 注册资金
     */
    private int registeredCapital;

    /**
     * 公司地址
     */
    private String cAddress;

    /**
     * 公司所属区域
     */
    private int localArea;

    /**
     * 评分
     */
    private int score;

    /**
     * 平台背景
     */
    private int pBackground;

    /**
     * 法人代表
     */
    private String legalRepersentative;

    /**
     * 上线时间
     */
    private Date uptime;

    /**
     * 联系电话
     */
    private String telPhone;

    /**
     * 平台网址
     */
    private String urlAddress;

    /**
     * 平台介绍
     */
    private String platformIntroduction;

    /**
     * 推荐理由
     */
    private String recommendedReason;

    /**
     * 风控情况
     */
    private String windControlSituation;

    /**
     * 管理费用
     */
    private int managerCost;

    /**
     * 项目类型
     */
    private String projectType;

    /**
     * 充值费用
     */
    private int prepaidCost;

    /**
     * 保障方式
     */
    private String safeguardWay;

    /**
     * 提现费用
     */
    private int withdrawalCost;

    /**
     * 担保机构
     */
    private String guaranteddInstitution;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }

    public int getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(int registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public int getLocalArea() {
        return localArea;
    }

    public void setLocalArea(int localArea) {
        this.localArea = localArea;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public int getpBackground() {
        return pBackground;
    }

    public void setpBackground(int pBackground) {
        this.pBackground = pBackground;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public String getLegalRepersentative() {
        return legalRepersentative;
    }

    public void setLegalRepersentative(String legalRepersentative) {
        this.legalRepersentative = legalRepersentative;
    }


    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public String getPlatformIntroduction() {
        return platformIntroduction;
    }

    public void setPlatformIntroduction(String platformIntroduction) {
        this.platformIntroduction = platformIntroduction;
    }

    public String getRecommendedReason() {
        return recommendedReason;
    }

    public void setRecommendedReason(String recommendedReason) {
        this.recommendedReason = recommendedReason;
    }

    public String getWindControlSituation() {
        return windControlSituation;
    }

    public void setWindControlSituation(String windControlSituation) {
        this.windControlSituation = windControlSituation;
    }

    public int getManagerCost() {
        return managerCost;
    }

    public void setManagerCost(int managerCost) {
        this.managerCost = managerCost;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public int getPrepaidCost() {
        return prepaidCost;
    }

    public void setPrepaidCost(int prepaidCost) {
        this.prepaidCost = prepaidCost;
    }

    public String getSafeguardWay() {
        return safeguardWay;
    }

    public void setSafeguardWay(String safeguardWay) {
        this.safeguardWay = safeguardWay;
    }

    public int getWithdrawalCost() {
        return withdrawalCost;
    }

    public void setWithdrawalCost(int withdrawalCost) {
        this.withdrawalCost = withdrawalCost;
    }

    public String getGuaranteddInstitution() {
        return guaranteddInstitution;
    }

    public void setGuaranteddInstitution(String guaranteddInstitution) {
        this.guaranteddInstitution = guaranteddInstitution;
    }
}
