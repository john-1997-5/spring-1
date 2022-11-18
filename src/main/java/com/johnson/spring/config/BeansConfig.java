package com.johnson.spring.config;

import com.johnson.spring.domain.vehicle.AudiVehicle;
import com.johnson.spring.domain.vehicle.ChevyVehicle;
import com.johnson.spring.domain.vehicle.TeslaVehicle;
import com.johnson.spring.domain.vehicle.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * La etiqueta @Configuration indica que la clase tiene una definición de un bean method.
 * De este modo el contenedor procesa la clase y genera el bean definido
 */
//@Configuration
public class BeansConfig {

    /**
     * @Bean indica al contenedor que tiene que llamar a este método
     * cuando inicializa su contexto y añade el valor de retorno a su contexto.
     * Si no se le asigna un nombre al bean, cogerá el nombre del método como nombre
     * del bean por default
     */
    @Bean
    public Vehicle vehicle() { // el bean se llamará "vehicle" (minúscula)
        return new AudiVehicle();
    }

    @Bean("coolVehicle")
    public Vehicle getCoolVehicle() { // el bean se llamará coolVehicle
        return new ChevyVehicle();
    }

    /**
     * @Primary permite settear un bean por defecto en caso de que existan
     * varias implementaciones para una misma clase
     */
    @Primary
    @Bean
    public Vehicle getDefaultVehicle() {
        return new TeslaVehicle();
    }

}
