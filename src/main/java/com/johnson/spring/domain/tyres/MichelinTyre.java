package com.johnson.spring.domain.tyres;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MichelinTyre implements Tyre{
    @Override
    public void rotate() {
        log.info("michelin quality!");
    }
}
