package com.vencore.microservicetemplate.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Reverse {
    private String text;
    private String result;
}
