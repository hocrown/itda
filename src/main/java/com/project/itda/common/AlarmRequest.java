package com.project.itda.common;


public class AlarmRequest {
    private String targetUserId;
    private String alarm;

    public AlarmRequest() {
    }

    public AlarmRequest(String targetUserId, String alarm) {
        this.targetUserId = targetUserId;
        this.alarm = alarm;
    }

    public String getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String getAlarm() {
        return alarm;
    }

    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }
}