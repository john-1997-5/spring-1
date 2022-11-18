package com.johnson.spring.domain.vehicle;

import com.johnson.spring.service.VehicleService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ChevyVehicle")
@Getter
@Setter
@ToString
public class ChevyVehicle implements Vehicle{
    private String model;

    @Autowired
    private VehicleService vehicleService;

    public ChevyVehicle() {
        this.model = "Chevy molón";
    }

}
