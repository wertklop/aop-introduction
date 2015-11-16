package ru.dnevnik.aop.spring;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author Kurbatov Gennadii
 * @since 15.11.15
 */
public class LoggableAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("LoggableAfterReturningAdvice: method=[" + method.getName() + "]");
    }
}
