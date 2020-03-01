package com.intergation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseA1 {
    @JsonProperty("list-service-connect")
    List<String> orderServiceConnect;
    long number;
}
