package com.activeMQ.project.serviceImpl;

import com.activeMQ.project.service.ConsumerService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    @JmsListener(destination = "MohammadRezaT_Queue", containerFactory = "consumerJmsListenerContainerFactory")
    public void getMessage(String message) {
        System.out.println("incoming message: " + message);
    }
}
