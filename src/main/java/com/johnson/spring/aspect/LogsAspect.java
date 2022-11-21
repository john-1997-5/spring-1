package com.johnson.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@Aspect
@Slf4j
@Order(1)
public class LogsAspect {

    /**
     * Ejecuta el siguiente aspecto para todas los métodos de todas las clases dentro del paquete
     * com.johnson.spring, y que tenga n parámetros
     *
     * @param proceedingJoinPoint permite proseguir con la ejecución del método después de ejecutar cierta lógica
     * @throws Throwable
     */
    @Around("execution(* com.johnson.spring.service.*.*(..))")
    public void log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("start of {}()", proceedingJoinPoint.getSignature().getName());
        Instant start = Instant.now();
        proceedingJoinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        log.info("Time took to execute method: {}", timeElapsed);
        log.info("end of {}()\n", proceedingJoinPoint.getSignature().getName());
    }

}
