package com.johnson.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary // default vehicle
@Component
@Getter
@Setter
@ToString
public class TeslaVehicle implements Vehicle{
    private String model;
    public TeslaVehicle() {
        this.model = "Tesla model 3";
    }
}
