package io.micrologs.notification.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResponse {

    List<NotificationDTO> notifications = new ArrayList<>();

    public void addNotification(NotificationDTO notification) {
        notifications.add(notification);
    }

}
