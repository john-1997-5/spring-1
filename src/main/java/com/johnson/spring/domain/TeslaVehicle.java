package com.johnson.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Primary // default vehicle
@Component
@Getter
@Setter
@ToString
@Slf4j
public class TeslaVehicle implements Vehicle{
    private String model;
    public TeslaVehicle() {
        this.model = "Tesla model 3";
    }

    @PostConstruct
    public void init() {
        log.info("--> acabo de ser creado");
    }

    @PreDestroy
    public void destroy() {
        log.info("--> estoy a punto de morir...");

    }
}
