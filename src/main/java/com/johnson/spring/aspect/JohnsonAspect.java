package com.johnson.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@Aspect
@Slf4j
public class JohnsonAspect {

    @Around("execution(* com.johnson.spring.service.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("start of {}()", joinPoint.getSignature().getName());
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        log.info("Time took to execute method: {}", timeElapsed);
        log.info("end of {}()\n", joinPoint.getSignature().getName());
    }

}
