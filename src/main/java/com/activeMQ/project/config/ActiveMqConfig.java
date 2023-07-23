package com.activeMQ.project.config;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Queue;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMqConfig {
    @Value("${producer.activemq.broker-url}")
    private String myBrokerUrl;

    @Value("${consumer.activemq.broker-url}")
    private String hisBrokerUrl;

    @Bean
    public Queue producerQueue() {
        return new ActiveMQQueue("MohammadMahdiS_Queue");
    }

    @Bean
    public Queue consumerQueue() {
        return new ActiveMQQueue("MohammadRezaT_Queue");
    }

    @Bean
    public ConnectionFactory producerConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(myBrokerUrl);

        return activeMQConnectionFactory;
    }

    @Bean
    public ConnectionFactory consumerConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(hisBrokerUrl);

        return activeMQConnectionFactory;
    }

    @Bean
    public JmsTemplate producerJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(producerConnectionFactory());
        return jmsTemplate;
    }

    @Bean
    public JmsTemplate consumerJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(consumerConnectionFactory());
        return jmsTemplate;
    }

    @Bean
    public DefaultJmsListenerContainerFactory consumerJmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(consumerConnectionFactory());
        return factory;
    }

}
