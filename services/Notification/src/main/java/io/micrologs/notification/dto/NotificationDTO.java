package io.micrologs.notification.dto;

import java.time.Instant;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {

    private String title;
    private String description;
    private Instant emmited_at;
    private String userid;
    private String serviceName;
    private UUID notification_id;

}