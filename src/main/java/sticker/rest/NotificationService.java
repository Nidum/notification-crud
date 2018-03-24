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

    @RequestMapping(value = "/notification/all")
    List<Notification> getNotifications() {
        List<Notification> allNotifications = notificationRepository.getAll();
        return allNotifications;
    }

    @RequestMapping(value = "/notification/{id}")
    Notification getNotification(@PathVariable("id") long id) {
        return notificationRepository.find(id);
    }

    @RequestMapping(value = "/notification/new", method = RequestMethod.POST)
    void createNotification(@RequestBody Notification notification) {
        notificationRepository.create(notification);
    }

    @RequestMapping(value = "/notification", method = RequestMethod.PUT)
    void updateNotification(@RequestBody Notification notification) {
        notificationRepository.update(notification);
    }

    @RequestMapping(value = "/notification/{id}", method = RequestMethod.DELETE)
    void deleteNotification(@PathVariable("id") long id) {
        notificationRepository.delete(id);
    }
}
