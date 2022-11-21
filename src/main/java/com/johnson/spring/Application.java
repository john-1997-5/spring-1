package com.johnson.spring;


import com.johnson.spring.domain.Person;
import com.johnson.spring.domain.song.Song;
import com.johnson.spring.domain.vehicle.Vehicle;
import com.johnson.spring.exception.VehicleNotStartedException;
import com.johnson.spring.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) throws VehicleNotStartedException {
        var ctx = SpringApplication.run(Application.class, args);
        VehicleService vehicleService = ctx.getBean(VehicleService.class);
        log.info("bean of type {}\n", vehicleService.getClass());

        Song song = new Song();
        vehicleService.playMusic(false, song);
        vehicleService.move(true);
        vehicleService.brake(true);
    }

}
