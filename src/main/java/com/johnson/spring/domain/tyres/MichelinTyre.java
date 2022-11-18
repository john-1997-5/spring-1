package com.johnson.spring.domain.tyres;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@Slf4j
public class MichelinTyre implements Tyre{
    @Override
    public void rotate() {
        log.info(" -> Rodando con neumáticos Michelin!");
    }

    @Override
    public void stop() {
        log.info(" -> Frenado con neumáticos Michelin!");
    }
}
