package com.johnson.spring.domain.speaker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SonySpeaker implements Speaker{
    @Override
    public void makeSound() {
        log.info("bass sound from sony!");
    }
}
