package com.vencore.microservicetemplate.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Anagram {
    private String text;
    private Long seed;
    private String result;
}
