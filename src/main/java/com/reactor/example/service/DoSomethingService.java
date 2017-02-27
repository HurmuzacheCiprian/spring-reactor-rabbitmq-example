package com.reactor.example.service;

import com.reactor.example.model.EventData;
import com.reactor.example.model.SendData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.bus.Event;
import reactor.fn.Consumer;

import java.time.ZonedDateTime;

@Service
public class DoSomethingService implements Consumer<Event<EventData>> {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void accept(Event<EventData> stringEvent) {
        int count = countUniqueChars(stringEvent.getData().getData());
        restTemplate.postForEntity("http://localhost:8095/output",
                SendData.builder()
                        .count(count)
                        .eventData(stringEvent.getData())
                        .uuid(stringEvent.getId().toString())
                        .now(ZonedDateTime.now().toString())
                        .build(), SendData.class);
    }

    private int countUniqueChars(String str) {
        int[] array = new int[200];
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (array[c] == 0) {
                array[c] = 1;
                count++;
            }
        }
        return count;
    }

}
