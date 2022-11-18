package com.johnson.spring.domain.speaker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BoseSpeaker implements Speaker{
    @Override
    public void makeSound() {
        log.info("clean sound by Bose");
    }
}
