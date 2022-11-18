package com.johnson.spring.domain;

import com.johnson.spring.domain.vehicle.Vehicle;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Getter
@ToString
@Slf4j
public class Person {
    private String name = "johnson";

    @Autowired
    private Vehicle vehicle;

    public Person(){
        log.info("-> Person se ha creado!");
    }

}
