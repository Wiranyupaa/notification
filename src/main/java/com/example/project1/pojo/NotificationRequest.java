package com.example.project1.pojo;
import lombok.Getter;

@Getter
public class NotificationRequest {
    private String userId;
    private String orderId;

    public NotificationRequest(String userId, String orderId) {
        this.userId = userId;
        this.orderId = orderId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
