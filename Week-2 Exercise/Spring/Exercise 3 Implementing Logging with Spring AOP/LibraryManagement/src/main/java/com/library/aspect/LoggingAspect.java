package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Before("execution(* com.library.service.BookService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        System.out.println("Entering method: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.library.service.BookService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        long duration = System.currentTimeMillis() - startTime.get();
        System.out.println("Exiting method: " + joinPoint.getSignature().getName());
        System.out.println("Method execution time: " + duration + " milliseconds");
        startTime.remove();
    }
}
