package sticker.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sticker.entity.Notification;
import sticker.repository.NotificationRepository;

import java.util.List;

/**
 * Created by Emiliia Nesterovych on 3/17/2018.
 */
@RestController
public class NotificationService {

    @Autowired
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping(value = "/notification/all")
    List<Notification> getNotifications() {
        List<Notification> allNotifications = notificationRepository.getAll();
        return allNotifications;
    }

    @GetMapping(value = "/notification/{id}")
    Notification getNotification(@PathVariable("id") long id) {
        return notificationRepository.find(id);
    }

    @PostMapping(value = "/notification/new")
    void createNotification(@RequestBody Notification notification) {
        notificationRepository.create(notification);
    }

    @PutMapping(value = "/notification")
    void updateNotification(@RequestBody Notification notification) {
        notificationRepository.update(notification);
    }

    @DeleteMapping(value = "/notification/{id}")
    void deleteNotification(@PathVariable("id") long id) {
        notificationRepository.delete(id);
    }
}
