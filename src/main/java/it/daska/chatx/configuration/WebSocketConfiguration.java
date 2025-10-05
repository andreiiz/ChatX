package it.daska.chatx.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    //path di connessione per il client al WebSocket
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").withSockJS(); // l’endpoint di connessione WebSocket → usato una volta all'inizio per aprire la connessione.
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //instrada i messaggi al server (metodi gestiti da controller)
        config.setApplicationDestinationPrefixes("/app"); // il client dovra mandare il messaggio a /app/chat.sendMessage", e arrivera al metodo del mio controller annotato con MessageMapping
        //instrada i messaggi al broker. Topic broadcast, queue unicast
        config.enableSimpleBroker("/topic", "/queue"); //Server → Client (broadcast) [topic] , //Server → Client (unicast] [queue]
    }
}
