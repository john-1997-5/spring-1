package com.johnson.spring.aspect;

import com.johnson.spring.exception.VehicleNotStartedException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@Aspect
@Slf4j
//@Order(1)
public class LogsAspect {

    /**
     * Ejecuta el siguiente aspecto para todas los métodos de todas las clases dentro del paquete
     * com.johnson.spring, y que tenga n parámetros
     *
     * @param proceedingJoinPoint permite proseguir con la ejecución del método después de ejecutar cierta lógica
     * @throws Throwable
     */
    @Around("com.johnson.spring.aspect.pointcut.PointcutService.getPointcut()")
    public void log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("start of {}()", proceedingJoinPoint.getSignature().getName());
        Instant start = Instant.now();
        proceedingJoinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        log.info("Time took to execute method: {}", timeElapsed);
        log.info("end of {}()\n", proceedingJoinPoint.getSignature().getName());
    }

    /**
     * Aspecto que se ejecuta cuando hay excepción en el pointcut
     * Mirar que el nombre de la excepción debe coincidir con la de throwing
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "com.johnson.spring.aspect.pointcut.PointcutService.getPointcut()", throwing = "ex" )
    public void logException(JoinPoint joinPoint, VehicleNotStartedException ex) {
        log.error("Error in method: {}() -> {}", joinPoint.getSignature().getName(), ex.getMessage());
    }

    @AfterReturning("com.johnson.spring.aspect.pointcut.PointcutService.getPointcut()")
    public void logStatus(JoinPoint joinPoint) {
        log.info("{}() executed succesfully!", joinPoint.getSignature().getName());
    }
}
