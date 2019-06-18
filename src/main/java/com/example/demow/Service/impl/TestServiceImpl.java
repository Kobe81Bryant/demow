package com.example.demow.Service.impl;

import com.example.demow.Service.TestService;
import com.example.demow.socket.SpringWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private SpringWebSocketHandler springWebSocketHandler;


    @Override
    public void test1() throws IOException {
        springWebSocketHandler.sendMessageToUser("oaVE75JJ4OEMDIQUVPALs9QzUhrw",new TextMessage("sssss"));
    }
}
