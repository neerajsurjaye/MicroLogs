package io.micrologs.notification.config;

import java.net.InetSocketAddress;
import java.sql.PreparedStatement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.oss.driver.api.core.CqlSession;

import io.micrologs.notification.properties.CassandraConfigProperties;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class CassandraConfig {

    private final CassandraConfigProperties cassProps;

    CassandraConfig(CassandraConfigProperties cassProps) {
        this.cassProps = cassProps;
    }

    @Bean
    public CqlSession getSession() {
        CqlSession cqlSession = CqlSession.builder()
                .addContactPoint(new InetSocketAddress(cassProps.getHost(), cassProps.getPort()))
                .withLocalDatacenter(cassProps.getDatacenter()).build();

        log.error(
                "Using CQLSession :: " + cqlSession.toString() + " " + cqlSession.getMetadata().getClusterName().get());

        createKeyspace(cqlSession);
        createTable(cqlSession);

        return cqlSession;
    }

    private void createKeyspace(CqlSession session) {
        session.execute(
                """
                        CREATE KEYSPACE IF NOT EXISTS micrologs WITH REPLICATION = {'class' : 'NetworkTopologyStrategy', 'spec' : '1'};
                        """);
    }

    private void createTable(CqlSession session) {
        session.execute("""
                    CREATE TABLE IF NOT EXISTS micrologs.notifications(
                    userid text,
                    notification_id uuid,
                    title text,
                    description text,
                    emmited_at bigint,
                    message_read Boolean,
                    service text,
                    PRIMARY KEY((userid), emmited_at, notification_id));
                """);
    }

}