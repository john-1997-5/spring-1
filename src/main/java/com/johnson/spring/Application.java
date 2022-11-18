package com.johnson.spring;

import com.johnson.spring.domain.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(Application.class, args);
        Vehicle vehicle = ctx.getBean("audiVehicle", Vehicle.class);
        Vehicle coolVehicle = ctx.getBean("coolVehicle", Vehicle.class); // con nombre del @Bean

        log.info("normal vehicle: {}", vehicle);
        log.info("cool vehicle: {}", coolVehicle);

        Vehicle defaultVehicle = ctx.getBean(Vehicle.class); // por default con @Primary
        log.info("default vehicle: {}", defaultVehicle);

    }

}
