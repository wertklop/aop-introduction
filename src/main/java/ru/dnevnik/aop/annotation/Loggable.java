package ru.dnevnik.aop.annotation;

import java.lang.annotation.*;

/**
 * @author Kurbatov Gennadii
 * @since 01.11.15
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Loggable {
}
