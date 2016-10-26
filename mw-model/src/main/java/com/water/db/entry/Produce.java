package com.water.db.entry;

import java.sql.Date;

/**
 * Created by mrwater on 16/8/31.
 * 投标信息实体类
 */
public class Produce implements java.io.Serializable {

    private int id;
    /**
     * 所属平台
     */
    private int platformId;

    /**
     * 标名称
     */
    private String name;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 标的总额
     */
    private int totalCapital;

    /**
     * 投标限额
     */
    private int quota;

    /**
     * 年化率(项目收益)
     */
    private float annualRate;

    /**
     * 本平台提供的年化率
     */
    private float selfAnnualRate;

    /**
     * 期限
     */
    private int term;

    /**
     * 起投金额
     */
    private int startMount;

    /**
     * 还款方式
     */
    private int repaymentWay;

    /**
     * 计息方式
     */
    private int bearingWay;

    /**
     * 保障方式
     */
    private int safeGuardWay;

    /**
     * 所属模块(新手区,优选区)
     */
    private int module;

    /**
     * 创建时间
     */
    private Date createon;

    //----------------------------静态变量--------------------------------------------//
    public static int CATEGORY_NEWCOMER = 1;     //新手专区
    public static int CATEGORY_CURATON  = 2;     //精选专区

    //-------------------------------------------------------------------------------//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(int totalCapital) {
        this.totalCapital = totalCapital;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public float getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(float annualRate) {
        this.annualRate = annualRate;
    }

    public float getSelfAnnualRate() {
        return selfAnnualRate;
    }

    public void setSelfAnnualRate(float selfAnnualRate) {
        this.selfAnnualRate = selfAnnualRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getStartMount() {
        return startMount;
    }

    public void setStartMount(int startMount) {
        this.startMount = startMount;
    }

    public int getRepaymentWay() {
        return repaymentWay;
    }

    public void setRepaymentWay(int repaymentWay) {
        this.repaymentWay = repaymentWay;
    }

    public int getBearingWay() {
        return bearingWay;
    }

    public void setBearingWay(int bearingWay) {
        this.bearingWay = bearingWay;
    }

    public int getSafeGuardWay() {
        return safeGuardWay;
    }

    public void setSafeGuardWay(int safeGuardWay) {
        this.safeGuardWay = safeGuardWay;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public Date getCreateon() {
        return createon;
    }

    public void setCreateon(Date createon) {
        this.createon = createon;
    }
}
