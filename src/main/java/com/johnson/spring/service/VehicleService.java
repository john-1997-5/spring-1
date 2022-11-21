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
        speaker.makeSound(song);
    }

    public void move(boolean vehicleStarted) {
        tyre.rotate();
    }

    public void brake(boolean vehicleStarted) {
        tyre.stop();
    }
}
