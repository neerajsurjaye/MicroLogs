// package io.micrologs.notification.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.DependsOn;
// import org.springframework.messaging.simp.SimpMessagingTemplate;

// import lombok.extern.slf4j.Slf4j;

// @Configuration
// @DependsOn("socketConfig")
// @Slf4j
// public class SockerRunnerConfig {

// private final SimpMessagingTemplate messageingTemplate;

// public SockerRunnerConfig(SimpMessagingTemplate messageingTemplate) {
// this.messageingTemplate = messageingTemplate;

// new Thread(() -> {

// while (true) {
// this.messageingTemplate.convertAndSend("/notification/broadcast",
// "{\"Message\" : \"Message\"}");
// log.error("==Sending Message==");
// try {
// Thread.sleep(5000);
// } catch (InterruptedException e) {
// e.printStackTrace();
// }
// }

// }).start();

// }

// }
