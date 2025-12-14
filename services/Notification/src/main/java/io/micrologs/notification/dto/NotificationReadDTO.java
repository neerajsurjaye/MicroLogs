package io.micrologs.notification.dto;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class NotificationReadDTO {

    String userid;
    Instant emmited_at;
    UUID notification_id;

}
