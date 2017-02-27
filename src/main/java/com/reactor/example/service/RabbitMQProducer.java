package com.reactor.example.service;

import com.reactor.example.model.EventData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String string) {
        rabbitTemplate.convertAndSend(createEvent(string));
    }

    private EventData createEvent(String string) {
        EventData event = new EventData();
        event.setData(string);
        event.setStartTime(System.currentTimeMillis());
        return event;
    }


}
