package sticker.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sticker.entity.Notification;
import sticker.repository.NotificationRepository;

import javax.transaction.Transactional;
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
    public List<Notification> getNotifications() {
        List<Notification> allNotifications = notificationRepository.getAll();
        return allNotifications;
    }

    @GetMapping(value = "/notification/{id}")
    public Notification getNotification(@PathVariable("id") long id) {
        return notificationRepository.find(id);
    }

    @Transactional
    @PostMapping(value = "/notification/new")
    public void createNotification(@RequestBody Notification notification) {
        notificationRepository.create(notification);
    }

    @Transactional
    @PutMapping(value = "/notification")
    public void updateNotification(@RequestBody Notification notification) {
        notificationRepository.update(notification);
    }

    @Transactional
    @DeleteMapping(value = "/notification/{id}")
    public void deleteNotification(@PathVariable("id") long id) {
        notificationRepository.delete(id);
    }
}
