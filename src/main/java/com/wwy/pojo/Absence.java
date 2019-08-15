package com.wwy.pojo;

import java.net.URLDecoder;

/**
 * 请假表
 */
public class Absence {
    private String startTime;//开始时间
    private String endTime;
    private int isPermission;//是否批准
    private int eid;//员工id
    private String reason;//请假原因
    private String reply;//回复信息


    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getIsPermission() {
        return isPermission;
    }

    public void setIsPermission(int isPermission) {
        this.isPermission = isPermission;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Absence{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", isPermission=" + isPermission +
                ", eid=" + eid +
                ", reason='" + reason + '\'' +
                ", reply='" + reply + '\'' +
                '}';
    }
}
