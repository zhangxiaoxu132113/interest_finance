package com.water.db.entry;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/19.
 */
public class User2BidInfo implements java.io.Serializable {

    /**主键*/
    private int id;

    /**用户主键*/
    private int userId;

    /**标的主键*/
    private int bidId;

    /**平台的主键ID*/
    private int platformId;

    /**订单单号*/
    private String orderNumber;

    /**投资金额*/
    private BigDecimal investmentAmount;

    /**加息券*/
    private int interestRateCoupon;

    /**本平台收益*/
    private BigDecimal selfPlatformReveue;

    /**平台收益*/
    private BigDecimal platformReveue;

    /**创建时间*/
    private Date createdOn;

    /**状态（冻结，返利，跳转）*/
    private int status;

    /**冻结时间*/
    private Date freezingTime;

    /**返利时间*/
    private Date returnTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(BigDecimal investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public int getInterestRateCoupon() {
        return interestRateCoupon;
    }

    public void setInterestRateCoupon(int interestRateCoupon) {
        this.interestRateCoupon = interestRateCoupon;
    }

    public BigDecimal getPlatformReveue() {
        return platformReveue;
    }

    public void setPlatformReveue(BigDecimal platformReveue) {
        this.platformReveue = platformReveue;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getFreezingTime() {
        return freezingTime;
    }

    public void setFreezingTime(Date freezingTime) {
        this.freezingTime = freezingTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public BigDecimal getSelfPlatformReveue() {
        return selfPlatformReveue;
    }

    public void setSelfPlatformReveue(BigDecimal selfPlatformReveue) {
        this.selfPlatformReveue = selfPlatformReveue;
    }

}
