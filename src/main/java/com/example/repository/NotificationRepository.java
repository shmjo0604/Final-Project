package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    
    List<Notification> findTop10ByMember_idOrderByNoDesc(String id);

    int countByMember_idAndChk(String id, int chk);

}
