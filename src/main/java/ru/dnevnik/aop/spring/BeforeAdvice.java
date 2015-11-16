package ru.dnevnik.aop.spring;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author Kurbatov Gennadii
 * @since 15.11.15
 */
public class BeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("BeforeAdvice: method=[" + method.getName() + "]");
    }
}
