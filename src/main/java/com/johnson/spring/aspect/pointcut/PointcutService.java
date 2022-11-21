package com.johnson.spring.aspect.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutService {

    @Pointcut("execution(* com.johnson.spring.service.*.*(..))")
    public void getPointcut(){}

}
