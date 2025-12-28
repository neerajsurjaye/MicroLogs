package io.micrologs.auth.service.notificationservice;

import java.time.Instant;

import io.micrologs.auth.constants.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class NotificationDTO {

    private String title;
    private String description;
    private long emmited_at;
    private String userid;
    private String serviceName;

    public NotificationDTO(String title, String description, String userid) {
        this.title = title;
        this.description = description;
        this.userid = userid;
        this.emmited_at = Instant.now().toEpochMilli();
        this.serviceName = Constants.SERVICE_NAME;
    }

    public NotificationDTO(String title, String description, int userid) {
        this.title = title;
        this.description = description;
        this.userid = String.valueOf(userid);
        this.emmited_at = Instant.now().toEpochMilli();
        this.serviceName = Constants.SERVICE_NAME;
    }

}