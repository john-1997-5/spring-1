package com.johnson.spring.service;

import com.johnson.spring.domain.speaker.Speaker;
import com.johnson.spring.domain.tyres.Tyre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)  // no es necesario ya que es singleton por defecto
public class VehicleService {
    @Autowired
    private Speaker sonySpeaker;
    @Autowired
    private Tyre michelinTyre;

    public void playMusic() {
        sonySpeaker.makeSound();
    }

    public void move() {
        michelinTyre.rotate();
    }
}
