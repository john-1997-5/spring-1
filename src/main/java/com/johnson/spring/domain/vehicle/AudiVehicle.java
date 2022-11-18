package com.johnson.spring.domain.vehicle;

import com.johnson.spring.service.VehicleService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // el bean se llamará audiVehicle (la primer minúscula)
@Getter
@Setter
@ToString
public class AudiVehicle implements Vehicle {
    private String model;

    @Autowired
    private VehicleService vehicleService;

    public AudiVehicle() {
        this.model = "Audi R8";
    }

}
