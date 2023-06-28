package org.interview.service.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Manny
 * @create 2023-06-28-16:11
 */

@ServerEndpoint("/websocket")
@Service
public class WebSocketServiceImpl {

    private Session session;

    private static ConcurrentHashMap<String, WebSocketServiceImpl> webSocketServerConcurrentHashMap = new ConcurrentHashMap();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketServerConcurrentHashMap.put(session.getId(), this);
        System.out.println("WebSocket opened: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("WebSocket message received: " + message);
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        try {
            //发送的消息也返回给当前连接，用于展示
            session.getBasicRemote().sendText(dateStr + "发送消息:" + message);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        webSocketServerConcurrentHashMap.remove(session.getId());
        System.out.println("WebSocket closed: " + closeReason);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("WebSocket error: " + throwable);
    }

}
