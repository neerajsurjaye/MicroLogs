// package io.micrologs.notification.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.socket.config.annotation.EnableWebSocket;
// import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
// import
// org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

// import io.micrologs.notification.Service.UserWebSocketHandler;

// @Configuration
// @EnableWebSocket
// public class SocketConfig implements WebSocketConfigurer {

// private final UserWebSocketHandler handler;

// public SocketConfig(UserWebSocketHandler handler) {
// this.handler = handler;
// }

// @Override
// public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
// registry.addHandler(handler, "/ws/notifications")
// .setAllowedOrigins("http://localhost:5173");
// }
// }
