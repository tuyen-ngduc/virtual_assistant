package com.tka.virtual_assistant.meet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;



import java.util.concurrent.ConcurrentHashMap;

public class MeetingWebSocketHandler extends TextWebSocketHandler {

    // Map lưu trữ WebSocketSession với sessionId làm khóa
    private final ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Lưu session vào Map khi kết nối thành công
        sessions.put(session.getId(), session);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // In ra thông điệp nhận được
        System.out.println("Nhận thông điệp: " + message.getPayload());

        // Gửi thông điệp đến tất cả các client kết nối
        for (WebSocketSession webSocketSession : sessions.values()) {
            if (webSocketSession.isOpen()) {
                webSocketSession.sendMessage(message);
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Xóa session khỏi Map khi kết nối đóng
        sessions.remove(session.getId());
    }
}
