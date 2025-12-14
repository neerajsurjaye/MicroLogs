package io.micrologs.notification.Service;

import java.io.IOException;
import org.springframework.stereotype.Service;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitService {

    public void ackMessage(Channel channel, long messageTag, boolean status) {

        try {
            if (status)
                channel.basicAck(messageTag, false);
            else
                channel.basicNack(messageTag, false, true);
        } catch (IOException ioex) {
            log.error("=======GOT EXCEPTION WHILE TRYING TO ACK MESSAAGE : {}", ioex);
        }

    }
}
