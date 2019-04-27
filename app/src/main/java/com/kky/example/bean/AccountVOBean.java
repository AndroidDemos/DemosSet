package com.kky.example.bean;


import androidx.room.Entity;

/*
 * @author Zeus
 * create at 2018/12/7 19:29
 * modify at 2018/12/7 19:29
 * modify because
 * description: TO FIT
 */
public class AccountVOBean {
    /**
     * banPay : false
     * banTime : 2018-11-20T05:52:04.141Z
     * errorTimes : 0
     * money : 0
     * pubKey : string
     * savePayPwd : false
     * uid : 0
     */
    private Long dbId;
    private boolean banPay;
    private String banTime;
    private Long errorTimes;
    private double money;
    private String pubKey;
    private boolean savePayPwd;
    private long uid;
    private int level;
    private String receiptCodeUrl;

    public Long getDbId() {
        return dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    public boolean isBanPay() {
        return banPay;
    }

    public void setBanPay(boolean banPay) {
        this.banPay = banPay;
    }

    public String getBanTime() {
        return banTime;
    }

    public void setBanTime(String banTime) {
        this.banTime = banTime;
    }

    public Long getErrorTimes() {
        return errorTimes;
    }

    public void setErrorTimes(Long errorTimes) {
        this.errorTimes = errorTimes;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }

    public boolean isSavePayPwd() {
        return savePayPwd;
    }

    public void setSavePayPwd(boolean savePayPwd) {
        this.savePayPwd = savePayPwd;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getReceiptCodeUrl() {
        return receiptCodeUrl;
    }

    public void setReceiptCodeUrl(String receiptCodeUrl) {
        this.receiptCodeUrl = receiptCodeUrl;
    }
}
