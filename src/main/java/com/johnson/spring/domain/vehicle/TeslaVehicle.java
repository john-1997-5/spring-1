package com.johnson.spring.domain.vehicle;

import com.johnson.spring.service.VehicleService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Primary // default vehicle
@Component
@Getter
@Setter
@ToString
@Slf4j
public class TeslaVehicle implements Vehicle{

    private String model;

    @Autowired
    private VehicleService vehicleService;

    public TeslaVehicle() {
        this.model = "Tesla model 3";
    }

}
