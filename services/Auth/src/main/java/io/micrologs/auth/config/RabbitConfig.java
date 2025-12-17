package io.micrologs.auth.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE = "MICROLOGS_NOTIFICATION_QUEUE";
    public static final String EXCHANGE = "MICROLOGS_NOTIFICATION_EXCHANGE";
    public static final String ROUTINGKEY_AUTH = "NOTIFICATION.AUTH";

}
