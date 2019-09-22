package com.springboot.advice;

import com.springboot.annotation.Auditable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * @author dicksonk
 */
@Aspect
@Component
public class AuditAdvice {

    @Before("@annotation(auditable)")
    public void audit(Auditable auditable) throws Throwable {
        System.out.println("Audit Advice With Data [" + auditable.value() + "]...");
    }
}
