package com.gongxm.bookreader.bean;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/7/21 11:50
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class UserInfo {

    private int id;
    private String model; // 手机型号
    private String version;// 系统版本
    private String operator;// 运营商
    private String imsi; // SIM卡串号
    private String mac;// 网卡地址
    private String ip; // 网络IP信息
    private String location;// 地理位置

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "UserInfo [id=" + id + ", model=" + model + ", version="
                + version + ", operator=" + operator + ", imsi=" + imsi
                + ", mac=" + mac + ", ip=" + ip + ", location=" + location
                + "]";
    }

}
