package com.springboot.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * @author dicksonk
 */
@Aspect
@Component
public class ControllerAdvice {

    @Before("execution(* com.springboot.controller.*.*(..))")
    public void logControllerUsage() {
        System.out.println("Controller Advice....");
    }
}
