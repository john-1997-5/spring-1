package com.johnson.spring.aspect;

import com.johnson.spring.exception.VehicleNotStartedException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//@Aspect
@Slf4j
//@Order(0)
public class VehicleStatusAspect {
    /**
     * Ejecuta el siguiente aspecto para todas los métodos de todas las clases dentro del paquete
     * com.johnson.spring, y que tenga n parámetros, pero el primero de ellos ha de ser vehicleStarted.
     *
     * @param joinPoint Al contrario que el proceedingJoinPoint, aquí no se tiene control sobre la ejecución
     *                  entera del pointcut, únicamente se tiene control sobre lo que pasa antes de la
     *                  ejecución del método
     * @param vehicleStarted Tiene que coincidir con el nombre puesto en args()
     */
    @Before("execution(* com.johnson.spring.service.*.*(..)) && args(vehicleStarted,..)")
    public void vehicleIsStarted(JoinPoint joinPoint, boolean vehicleStarted) throws VehicleNotStartedException {
        if (!vehicleStarted) {
            throw new VehicleNotStartedException("Vehicle not started!");
        }
    }
}
