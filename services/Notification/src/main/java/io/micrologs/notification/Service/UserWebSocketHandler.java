// package io.micrologs.notification.Service;

// import org.springframework.stereotype.Component;
// import org.springframework.web.socket.CloseStatus;
// import org.springframework.web.socket.TextMessage;
// import org.springframework.web.socket.WebSocketSession;
// import org.springframework.web.socket.handler.TextWebSocketHandler;

// import java.io.IOException;
// import java.net.URI;
// import java.util.Arrays;
// import java.util.Map;
// import java.util.concurrent.ConcurrentHashMap;

// @Component
// public class UserWebSocketHandler extends TextWebSocketHandler {

// // userId -> WebSocketSession
// private final Map<String, WebSocketSession> sessions = new
// ConcurrentHashMap<>();

// @Override
// public void afterConnectionEstablished(WebSocketSession session) {
// String userId = extractUserId(session);
// if (userId == null) {
// closeSilently(session);
// return;
// }

// // Ensure only ONE connection per user
// WebSocketSession oldSession = sessions.put(userId, session);
// if (oldSession != null && oldSession.isOpen()) {
// closeSilently(oldSession);
// }
// }

// @Override
// public void afterConnectionClosed(WebSocketSession session, CloseStatus
// status) {
// String userId = extractUserId(session);
// if (userId != null) {
// sessions.remove(userId);
// }
// }

// public void sendToUser(String userId, String payload) {
// WebSocketSession session = sessions.get(userId);
// if (session != null && session.isOpen()) {
// try {
// session.sendMessage(new TextMessage(payload));
// } catch (IOException e) {
// closeSilently(session);
// sessions.remove(userId);
// }
// }
// }

// private String extractUserId(WebSocketSession session) {
// URI uri = session.getUri();
// if (uri == null || uri.getQuery() == null)
// return null;

// return Arrays.stream(uri.getQuery().split("&"))
// .map(p -> p.split("="))
// .filter(p -> p.length == 2 && p[0].equals("userId"))
// .map(p -> p[1])
// .findFirst()
// .orElse(null);
// }

// private void closeSilently(WebSocketSession session) {
// try {
// session.close();
// } catch (IOException ignored) {
// }
// }
// }
