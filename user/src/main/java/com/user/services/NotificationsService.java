package com.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entities.Notifications;
import com.user.repositories.NotificationsRepository;

@Service
public class NotificationsService {

    private NotificationsRepository notificationsRepository;

    @Autowired
    public NotificationsService(NotificationsRepository notificationsRepository) {
        this.notificationsRepository = notificationsRepository;
    }

    public Notifications cadastrarNotification(String message, String link) {
        Notifications notification = new Notifications(message, link);
        return notificationsRepository.save(notification);
    }

    public List<Notifications> listarNotifications() {
        return notificationsRepository.findAll();
    }

    public void excluirNotification(Long id) {
        notificationsRepository.deleteById(id);
    }
}
