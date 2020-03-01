package com.intergation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestA1 {
    int number1;
    int number2;
    @JsonProperty("list-service-connect")
    List<String> orderServiceConnect;
}
