package com.johnson.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Person {
    private String name = "johnson";

    /**
     * Hay 3 implementaciones de Vehicle por lo que usaré @Qualifier para especificar la implemntación que quiero
     * en cada una de las inyecciones
     * El Audi lo inyectaré por atributo, el Chevy por setter y el Tesla por constructor.
     * La inyección por atributo y setter no permiten que sean final
     */
    @Autowired
    @Qualifier("audiVehicle")
    private Vehicle vehicle1;

    private Vehicle vehicle2;

    private final Vehicle vehicle3;

    // También se le puede pasar @Qualifier al constructor, pero como el Tesla lo tengo con @Primary pues
    // no hace falta
    @Autowired
    public Person(Vehicle teslaVehicle) {
        this.vehicle3 = teslaVehicle;
    }

    @Autowired
    @Qualifier("ChevyVehicle")
    public void setChevyVehicle(Vehicle chevyVehicle){
        this.vehicle2 = chevyVehicle;
    }

    @Override
    public String toString() {
        return "\n Person{" +
                "\n\t name='" + name + '\'' +
                "\n\t - attribute injection -> vehicle1: " + vehicle1 +
                "\n\t - setter injection -> vehicle2: " + vehicle2 +
                "\n\t - constructor injection -> vehicle3: " + vehicle3 +
                "\n }";
    }
}
