package com.reactor.example.resources;

import com.reactor.example.model.Response;
import com.reactor.example.model.SendData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class OutputResource {

    private final Map<String, SendData> store = new ConcurrentHashMap<>();

    @RequestMapping(value = "/output", method = RequestMethod.POST)
    public void store(@RequestBody SendData sendData) {
        sendData.getEventData().setEndTime(System.currentTimeMillis());
        sendData.setTotal(sendData.getEventData().getEndTime() - sendData.getEventData().getStartTime());
        store.putIfAbsent(sendData.getUuid(), sendData);
    }

    @RequestMapping(value = "/get-response", method = RequestMethod.GET)
    public ResponseEntity<Response> getStore() {
        return new ResponseEntity<>(Response.builder().total(store.size()).response(store.keySet()).build(), HttpStatus.ACCEPTED);
    }

}
