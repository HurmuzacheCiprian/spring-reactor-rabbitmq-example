package com.reactor.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString(of = {"data", "startTime", "endTime"})
public class EventData implements Serializable {
    private String data;
    private long startTime;
    private long endTime;
}
