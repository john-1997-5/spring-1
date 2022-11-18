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
        log.info("antes de inicializar el bean");
        Person person = ctx.getBean(Person.class);
        log.info("depues de inicializar el bean");
    }

}
