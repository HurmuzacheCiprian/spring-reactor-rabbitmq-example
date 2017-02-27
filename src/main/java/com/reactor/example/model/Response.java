package com.reactor.example.model;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by chu23 on 18/02/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Response implements Serializable {
    private Set<String> response;
    private int total;
}
