package com.water.db.entry;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/8/19.
 * 用户银行卡
 */
public class BankInfo implements java.io.Serializable {

    /**
     * 主键
     */
    private int ID;

    /**
     * 用户ID外键
     */
    private int userId;
    /**
     * 开户名称
     */
    private String accountName;

    /**
     * 开户身份证
     */
    private String cardId;

    /**
     * 银行卡号码
     */
    private String bankCardId;

    /**
     * 银行
     */
    private int bankCode;

    /**

     * 开户银行支行
     */
    private String bankBranch;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getAccountName() {
        return accountName;
    }


    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


    public String getCardId() {
        return cardId;
    }


    public void setCardId(String cardId) {
        this.cardId = cardId;
    }


    public String getBankCardId() {
        return bankCardId;
    }


    public void setBankCardId(String bankCardId) {
        this.bankCardId = bankCardId;
    }


    public int getBankCode() {
        return bankCode;
    }


    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }


    public String getBankBranch() {
        return bankBranch;
    }


    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }


    public Timestamp getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Test [accountName=" + accountName + ", bankBranch="
                + bankBranch + ", bankCardId=" + bankCardId + ", bankCode="
                + bankCode + ", cardId=" + cardId + ", createTime="
                + createTime + ", userId=" + userId + "]";
    }
}
