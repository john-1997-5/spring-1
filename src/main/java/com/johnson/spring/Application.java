package com.johnson.spring;


import com.johnson.spring.domain.Person;
import com.johnson.spring.domain.song.Song;
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
        VehicleService vehicleService = ctx.getBean(VehicleService.class);
        //Song song = ctx.getBean(Song.class); no crees beans de POJO's
        Song song = new Song();
        vehicleService.playMusic(true, song);
        vehicleService.move(true);
        vehicleService.brake(true);

    }

}
