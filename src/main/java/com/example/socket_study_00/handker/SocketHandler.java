package com.example.socket_study_00.handker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.logging.Logger;

@Component
@Slf4j
public class SocketHandler extends TextWebSocketHandler {
    private final static Logger LOG = Logger.getGlobal();
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        String input = message.getPayload();
        LOG.info(input);
        TextMessage textMessage = new TextMessage("hello test");
        session.sendMessage(textMessage);
    }



}
