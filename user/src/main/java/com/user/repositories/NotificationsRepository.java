package com.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entities.Notifications;

public interface NotificationsRepository extends JpaRepository<Notifications, Long>{

}
