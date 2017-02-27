package com.reactor.example.resources;

import com.reactor.example.service.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputResource {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public ResponseEntity test(@RequestParam("event_name") String eventName) {
        rabbitMQProducer.send(eventName);
        return new ResponseEntity(HttpStatus.OK);
    }


}
