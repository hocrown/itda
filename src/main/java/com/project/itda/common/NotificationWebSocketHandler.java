package com.project.itda.common;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationWebSocketHandler extends TextWebSocketHandler {
    private Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String userId = session.getPrincipal().getName(); // Assuming authentication
        sessions.put(userId, session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String userId = session.getPrincipal().getName();
        sessions.remove(userId);
    }

    public void sendNotification(String userId, String message) throws IOException {
        WebSocketSession session = sessions.get(userId);

        if (session != null && session.isOpen()) {
            session.sendMessage(new TextMessage(message));
        }
    }
    
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        // Handle received messages and send notifications as needed.
    }

    public void sendNotificationToUser(String userId, String notification) {
        sessions.values().forEach(session -> {
            try {
                session.sendMessage(new TextMessage(notification));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
