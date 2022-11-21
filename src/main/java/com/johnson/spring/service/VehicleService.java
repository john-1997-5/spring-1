package com.johnson.spring.service;

import com.johnson.spring.domain.song.Song;
import com.johnson.spring.domain.speaker.Speaker;
import com.johnson.spring.domain.tyres.Tyre;
import com.johnson.spring.exception.VehicleNotStartedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)  // no es necesario ya que es singleton por defecto
@Slf4j
public class VehicleService {
    @Autowired
    private Speaker speaker;

    @Autowired
    private Tyre tyre;

    public void playMusic(boolean vehicleStarted, Song song) throws VehicleNotStartedException {
        if (vehicleStarted) {
            speaker.makeSound(song);
        }
        throw new VehicleNotStartedException("Vehicle not started!");
    }

    public void move(boolean vehicleStarted) throws VehicleNotStartedException {
        if (vehicleStarted) {
            tyre.rotate();
        }
        throw new VehicleNotStartedException("Vehicle not started!");
    }

    public void brake(boolean vehicleStarted) throws VehicleNotStartedException {
        if (vehicleStarted) {
            tyre.stop();
        }
        throw new VehicleNotStartedException("Vehicle not started!");
    }
}
