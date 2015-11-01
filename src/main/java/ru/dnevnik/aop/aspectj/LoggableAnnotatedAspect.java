package ru.dnevnik.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author Kurbatov Gennadii
 * @since 01.11.15
 */
@Aspect
public class LoggableAnnotatedAspect {

    @Pointcut("execution(* (@ru.dnevnik.aop.annotation.Loggable *).*(..))")
    public void loggablePointcut() {}

    @Before("loggablePointcut()")
    public void executeBefore(JoinPoint joinPoint) {
        System.out.println("LoggableAnnotatedAspect. before execute method: " + joinPoint.getSignature());
    }

    @Around("loggablePointcut()")
    public Object executeAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("LoggableAnnotatedAspect. around execute method: " + joinPoint.getSignature());
        return joinPoint.proceed();
    }

    @After("loggablePointcut()")
    public void executeAfter(JoinPoint joinPoint) {
        System.out.println("LoggableAnnotatedAspect. after execute method: " + joinPoint.getSignature());
    }
}
