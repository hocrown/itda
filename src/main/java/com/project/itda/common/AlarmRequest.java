package com.project.itda.common;


public class AlarmRequest {
    private String userId;
    private String alarm;

    public AlarmRequest() {
    }

    public AlarmRequest(String userId, String alarm) {
        this.userId = userId;
        this.alarm = alarm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAlarm() {
        return alarm;
    }

    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }
}