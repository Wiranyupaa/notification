package com.example.project1.service;


import com.example.project1.pojo.User;
import com.example.project1.repository.UserRepository;
import com.example.project1.pojo.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationService {
    @Autowired
    private UserRepository userRepository;

//    @RequestMapping(value ="/send-notification", method = RequestMethod.GET)
//    public String getNotification(@RequestBody NotificationRequest request) {
//        User user = userRepository.findByUserId(request.getUserId());
//        String notificationMessage = "สวัสดี " + user.getName() + "! คำสั่งหมายเลข " + request.getOrderId() + " ของคุณถูกส่งแล้ว.";
//        System.out.println(notificationMessage);
//        return " get Notification สำเร็จ";
//    }

    @RequestMapping(value= "/send-notification", method = RequestMethod.POST)
    public String sendNotification(@RequestBody NotificationRequest request) {
        try {
            User user = userRepository.findByUserId(request.getUserId());

            if (user != null) {
                String notificationMessage = "สวัสดี " + user.getName() + "! คำสั่งหมายเลข " + request.getOrderId() + " ของคุณถูกส่งแล้ว.";
                System.out.println(notificationMessage);
                return "ส่ง Notification สำเร็จ";
            }
            else {
                return "ไม่พบข้อมูลผู้ใช้";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return "เกิดข้อผิดพลาด: " + e.getMessage();
        }
    }
}

