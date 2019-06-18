package com.example.demow.config;

import com.example.demow.interceptor.SpringWebSocketHandlerInterceptor;
import com.example.demow.socket.SpringWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Configuration
@Component
public class SpringWebSocketConfig implements WebSocketConfigurer {
    @Autowired
    private SpringWebSocketHandler springWebSocketHandler;

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(), "/websocket/message")
                .addInterceptors(new SpringWebSocketHandlerInterceptor()).setAllowedOrigins("*");
    }

    @Bean
    public TextWebSocketHandler webSocketHandler() {
        return springWebSocketHandler;
    }

}