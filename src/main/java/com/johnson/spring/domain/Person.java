package com.johnson.spring.domain;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Person {
    private String name = "johnson";

    @Autowired
    //@Qualifier("audiVehicle")
    private Vehicle audiVehicle; // si a la variable le pongo el mismo nombre que el bean, lo inyecta sin necesidad de un qualifier

    private Vehicle vehicle2;

    private final Vehicle vehicle3;

    @Autowired
    public Person(Vehicle teslaVehicle) { // mismo nombre que el bean (he quitado el @Primary o sea que no hay vehículo por defecto)
        this.vehicle3 = teslaVehicle;
    }

    @Autowired
    //@Qualifier("ChevyVehicle")
    public void setChevyVehicle(Vehicle ChevyVehicle){ // mismo nombre que el bean
        this.vehicle2 = ChevyVehicle;
    }

    @Override
    public String toString() {
        return "\n Person{" +
                "\n\t name='" + name + '\'' +
                "\n\t - attribute injection -> vehicle1: " + audiVehicle +
                "\n\t - setter injection -> vehicle2: " + vehicle2 +
                "\n\t - constructor injection -> vehicle3: " + vehicle3 +
                "\n }";
    }
}
