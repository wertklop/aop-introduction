package ru.dnevnik.aop.aspectj;

/**
 * @author Kurbatov Gennadii
 * @since 01.11.15
 */
public aspect LoggableAspect {

    pointcut loggablePointcut() : execution(* (@ru.dnevnik.aop.annotation.Loggable *).*(..));

    before() : loggablePointcut() {
        System.out.println("LoggableAspect. before execute method: " + thisJoinPoint.getSignature());
    }

    Object around() : loggablePointcut() {
        System.out.println("LoggableAspect. around execute method: " + thisJoinPoint.getSignature());
        return proceed();
    }

    after() : loggablePointcut() {
        System.out.println("LoggableAspect. after execute method: " + thisJoinPoint.getSignature());
    }
}
