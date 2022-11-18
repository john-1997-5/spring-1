package com.johnson.spring.service;

import com.johnson.spring.domain.song.Song;
import com.johnson.spring.domain.speaker.Speaker;
import com.johnson.spring.domain.tyres.Tyre;
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

    public void playMusic(boolean vehicleStarted, Song song) {
        Instant start = Instant.now();
        log.info("start of playMusic()");
        if (vehicleStarted) {
            speaker.makeSound(song);
        } else {
            log.error("Vehicle not started to perform the operation");
        }
        log.info("end of playMusic()");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        log.info("Time took to execute playMusic(): {}\n", timeElapsed);
    }

    public void move(boolean vehicleStarted) {
        Instant start = Instant.now();
        log.info("start of move()");
        if (vehicleStarted) {
            tyre.rotate();
        } else {
            log.error("Vehicle not started to perform the operation");
        }
        log.info("end of move()");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        log.info("Time took to execute move(): {}\n", timeElapsed);
    }

    public void brake(boolean vehicleStarted) {
        Instant start = Instant.now();
        log.info("start of brake()");
        if (vehicleStarted) {
            tyre.stop();
        } else {
            log.error("Vehicle not started to perform the operation");
        }
        log.info("end of brake()");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        log.info("Time took to execute brake(): {}\n", timeElapsed);
    }
}
