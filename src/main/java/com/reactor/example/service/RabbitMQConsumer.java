package com.reactor.example.service;

import com.reactor.example.model.EventData;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.bus.EventBus;

import javax.annotation.PostConstruct;

import static reactor.bus.selector.Selectors.$;

@Service
public class RabbitMQConsumer {

    @Autowired
    private EventBus eventBus;

    @Autowired
    private DoSomethingService service;

    @PostConstruct
    public void after() {
        eventBus.on($("count-chars"), service);
    }

    @RabbitListener(queues = "reactor")
    public void receiveMessage(EventData data) {
        eventBus.notify("count-chars", Event.wrap(data));
    }
//
//    @RabbitListener(queues = "reactor")
//    public void receiveMessage1(EventData data) {
//        eventBus.notify("count-chars", Event.wrap(data));
//    }
//
//    @RabbitListener(queues = "reactor")
//    public void receiveMessage2(EventData data) {
//        eventBus.notify("count-chars", Event.wrap(data));
//    }
//
//    @RabbitListener(queues = "reactor")
//    public void receiveMessage3(EventData data) {
//        eventBus.notify("count-chars", Event.wrap(data));
//    }

}
