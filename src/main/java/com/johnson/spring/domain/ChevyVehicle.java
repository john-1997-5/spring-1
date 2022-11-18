package com.johnson.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("coolVehicle")
@Getter
@Setter
@ToString
public class ChevyVehicle implements Vehicle{
    private String model;
    public ChevyVehicle() {
        this.model = "Chevy molón";
    }
}
