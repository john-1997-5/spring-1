package com.johnson.spring;


import com.johnson.spring.domain.Person;
import com.johnson.spring.domain.vehicle.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(Application.class, args);
        // Person tiene dependencia de Vehicle
        Person person = ctx.getBean(Person.class);
        Vehicle personVehicle = person.getVehicle();

        log.info("person: {}", person.getName());
        log.info("person's vehicle: {}", personVehicle.getModel());

        // Vehicle tiene dependencia de VehicleService
        //Vehicle vehicle = ctx.getBean("audiVehicle", Vehicle.class); // con nombre de bean
        Vehicle vehicle = ctx.getBean(Vehicle.class); // por defecto
        log.info("car model: {}", vehicle.getModel());
        vehicle.getVehicleService().move();
        vehicle.getVehicleService().playMusic();



    }

}
