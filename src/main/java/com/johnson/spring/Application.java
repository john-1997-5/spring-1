package com.johnson.spring;


import com.johnson.spring.domain.Person;
import com.johnson.spring.domain.vehicle.Vehicle;
import com.johnson.spring.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(Application.class, args);
        VehicleService vehicleService1 = ctx.getBean(VehicleService.class);
        VehicleService vehicleService2 = ctx.getBean(VehicleService.class);
        log.info("same reference? -> {}", vehicleService1 == vehicleService2); //apuntan a la misma referencia en memoria
        log.info("vehicleService1 reference -> {}", vehicleService1.hashCode());
        log.info("vehicleService2 reference -> {}", vehicleService2.hashCode());
    }

}
