package com.reactor.example.model;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = "uuid")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"total", "count", "eventData", "now"})
public class SendData {
    private String uuid = UUID.randomUUID().toString();
    private EventData eventData;
    private int count;
    private long total;
    private String now;
}
