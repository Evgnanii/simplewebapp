package com.mastery.java.task.config;

import com.mastery.java.task.ActiveMQ.MyMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import java.util.Collections;

@Configuration
public class ActiveMQConfigurations {
    @Bean
    MappingJackson2MessageConverter messageConverter() {
        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setTypeIdPropertyName("content-type");
        messageConverter.setTypeIdMappings(Collections.singletonMap("MyMessage", MyMessage.class));
        return messageConverter;
    }

}