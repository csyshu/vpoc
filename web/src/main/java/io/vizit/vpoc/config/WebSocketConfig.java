package io.vizit.vpoc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    public static final String WEBSOCKET_JVM = "/jvm";
    public static final String WEBSOCKET_TREE = "/tree";
    public static final String WEBSOCKET_KAFKA = "/kafka";

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic");
//        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(WEBSOCKET_JVM).withSockJS();
        registry.addEndpoint(WEBSOCKET_TREE).withSockJS();
        registry.addEndpoint(WEBSOCKET_KAFKA).withSockJS();
    }

}