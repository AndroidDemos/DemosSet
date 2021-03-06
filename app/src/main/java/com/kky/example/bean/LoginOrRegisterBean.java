package com.kky.example.bean;

/*
 * @author Zeus
 * create at 2019/1/15 18:37
 * modify at 2019/1/15 18:37
 * modify because
 * description: TO FIT
 */
public class LoginOrRegisterBean {
    /**
     * code : string
     * deviceId : string
     * deviceName : string
     * mobile : string
     */

    private String code;
    private String deviceId;
    private String deviceName;
    private String mobile;
    private String regSource;
    private String mobilePrefix;
    private String version;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRegSource() {
        return regSource;
    }

    public void setRegSource(String regSource) {
        this.regSource = regSource;
    }

    public String getMobilePrefix() {
        return mobilePrefix;
    }

    public void setMobilePrefix(String mobilePrefix) {
        this.mobilePrefix = mobilePrefix;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
