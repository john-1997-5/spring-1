package com.johnson.spring.domain.tyres;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BridgestoneTyre implements Tyre{
    @Override
    public void rotate() {
        log.info("-> Rodando con neumáticos Michelin");
    }

    @Override
    public void stop() {
        log.info("-> Frenado con neumáticos Bridgestone");
    }
}
