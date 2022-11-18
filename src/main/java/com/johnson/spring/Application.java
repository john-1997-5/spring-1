package com.johnson.spring;

import com.johnson.spring.domain.Person;
import com.johnson.spring.domain.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.Supplier;


@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(Application.class, args);
        Person person = ctx.getBean(Person.class);
        log.info("person: {}", person);

    }

}
