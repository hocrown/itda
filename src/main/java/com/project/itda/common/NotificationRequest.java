package com.project.itda.common;


public class NotificationRequest {
    private String targetUserId;
    private String notification;

    public NotificationRequest() {
    }

    public NotificationRequest(String targetUserId, String notification) {
        this.targetUserId = targetUserId;
        this.notification = notification;
    }

    public String getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}