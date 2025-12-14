package io.micrologs.notification.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "cassandra.prop")
@Data
public class CassandraConfigProperties {

    private String host;
    private Integer port;
    private String datacenter;

}
