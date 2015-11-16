package ru.dnevnik.aop.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Kurbatov Gennadii
 * @since 15.11.15
 */
public class AroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("AroundAdvice: invocation=[" + invocation + "]");
        Object rval = invocation.proceed();
        System.out.println("AroundAdvice: Invocation returned: " + rval);
        return rval;
    }
}
