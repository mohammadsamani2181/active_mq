package com.activeMQ.project.serviceImpl;

import com.activeMQ.project.service.ProducerService;
import jakarta.jms.Queue;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {
    @Qualifier("producerJmsTemplate")
    @Autowired
    private JmsTemplate jmsTemplate;

    @Qualifier("producerQueue")
    @Autowired
    private Queue queue;

    @Override
    public String sendMessage(String message) {
        try {
            jmsTemplate.convertAndSend(queue, message);
        } catch (Exception e) {
            throw e;
        }

        return "message sent";
    }
}
