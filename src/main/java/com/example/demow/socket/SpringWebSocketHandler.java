package com.example.demow.socket;

import com.alibaba.fastjson.JSON;
import com.example.demow.Service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class SpringWebSocketHandler extends TextWebSocketHandler {
    //键为open_id,值为socketSession
    private static final ConcurrentHashMap<String, WebSocketSession> userMap;
    static {
        userMap = new ConcurrentHashMap();
    }

    public SpringWebSocketHandler() {
    }

    private String getOpenId(WebSocketSession socketSession) {
        String open_id = (String) socketSession.getAttributes().get("open_id");
        return open_id;
    }

    /**
     * 连接成功时候，会触发页面上onopen方法
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO Auto-generated method stub
        String openId = (String) session.getAttributes().get("open_id");
        System.out.println("connect to the websocket success......当前数量:" + userMap.size());
        WebSocketSession open_id = userMap.get((String) session.getAttributes().get("open_id"));
        if (open_id != null && open_id.isOpen()) {
            open_id.close();
        }
        userMap.remove((String) session.getAttributes().get("open_id"));

        userMap.put((String) session.getAttributes().get("open_id"), session);
        System.out.println("connect to the websocket success......当前数量:" + userMap.size());
        //这块会实现自己业务，比如，当用户登录后，会把离线消息推送给用户
        TextMessage returnMessage = new TextMessage(JSON.toJSONString("asd"));
        session.sendMessage(returnMessage);
    }

    /**
     * 关闭连接时触发
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.debug("websocket connection closed......");
        String openId = getOpenId(session);
        System.out.println("用户" + openId + "已退出！");
        userMap.remove(openId);
        System.out.println("剩余在线用户" + userMap.size());
    }

    /**
     * js调用websocket.send时候，会调用该方法
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info(JSON.toJSONString(message));
        super.handleTextMessage(session, message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        log.debug("websocket connection closed......");
        userMap.remove(getOpenId(session));
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }


    /**
     * 给某个用户发送消息
     *
     * @param openId
     * @param message
     */
    public void sendMessageToUser(String openId, TextMessage message) throws IOException {
        log.info("开始发送socket消息，openid："+openId);
        WebSocketSession webSocketSession = userMap.get(openId);
        if (webSocketSession!=null&&webSocketSession.isOpen()) {
            webSocketSession.sendMessage(new TextMessage(JSON.toJSONString("fsdfsdfdsfdsf")));
        }
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) throws IOException {
        for (String s : userMap.keySet()) {
            WebSocketSession webSocketSession = userMap.get(s);
            if (webSocketSession.isOpen()) {
                webSocketSession.sendMessage(message);
            }
        }
    }

    public static ConcurrentHashMap<String, WebSocketSession> getUserMap() {
        return userMap;
    }

//    public void sendMessageUser(Integer messageId) throws Exception{
//        TbMessage message = messageService.getMessage(messageId);
//        String openId = userService.getOpenId(message.getTargetUserId());
//        WebSocketSession session = userMap.get(openId);
//        if (session!=null&&session.isOpen()){
//            session.sendMessage(new TextMessage(JSON.toJSONString(message)));
//            messageService.updateSendMessage(messageId);
//        }
//    }
}