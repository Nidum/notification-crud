package sticker.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Emiliia Nesterovych on 3/17/2018.
 */
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(nullable = false)
    private String content;
    @Column(name = "notification_time", nullable = false)
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    @DateTimeFormat(style = "dd.MM.yyyy HH:mm")
    private LocalDateTime notificationTime;
    @Column(nullable = false)
    private boolean done;

    public Notification() {
    }

    public Notification(String content, LocalDateTime notificationTime, boolean done) {
        this.content = content;
        this.notificationTime = notificationTime;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(LocalDateTime notificationTime) {
        this.notificationTime = notificationTime;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
