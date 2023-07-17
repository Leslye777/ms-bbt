package com.user.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.user.entities.Notifications;
import com.user.services.NotificationsService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationsResource {


    private NotificationsService notificationsService;

    @Autowired
    public NotificationsResource(NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }

    @PostMapping
    public ResponseEntity<Notifications> cadastrarNotification(@RequestBody Notifications request) {
        Notifications notification = notificationsService.cadastrarNotification(request.getLink(), request.getMessage());
        return ResponseEntity.status(HttpStatus.CREATED).body(notification);
    }

    @GetMapping
    public ResponseEntity<List<Notifications>> listarNotifications() {
        List<Notifications> notifications = notificationsService.listarNotifications();
        return ResponseEntity.ok(notifications);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirNotification(@PathVariable Long id) {
        notificationsService.excluirNotification(id);
        return ResponseEntity.noContent().build();
    }

}
