package com.hps.notificationservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${notification.queues.msgQueue}")
    private String msgQueue;

    @Value("${notification.queues.otpQueue}")
    private String otpQueue;

    @Value("${notification.exchange}")
    private String exchange;

    @Value("${notification.msgRoutingKey}")
    private String msgRoutingKey;

    @Value("${notification.otpRoutingKey}")
    private String otpRoutingKey;

    @Bean
    Queue msgQueue() {
        return new Queue(msgQueue, false);
    }

    @Bean
    Queue otpQueue() {
        return new Queue(otpQueue, false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding msgBinding(Queue msgQueue, DirectExchange exchange) {
        return BindingBuilder.bind(msgQueue).to(exchange).with(msgRoutingKey);
    }

    @Bean
    Binding otpBinding(Queue otpQueue, DirectExchange exchange) {
        return BindingBuilder.bind(otpQueue).to(exchange).with(otpRoutingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(jsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        factory.setDefaultRequeueRejected(false);
        return factory;
    }
}
