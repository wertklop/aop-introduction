package ru.dnevnik.aop.configuration;

import org.springframework.beans.factory.annotation.AnnotationBeanWiringInfoResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ru.dnevnik.aop.repository.BookRepository;

/**
 * @author Kurbatov Gennadii
 * @since 01.11.15
 */
@Configuration
@EnableWebMvc
@ComponentScan("ru.dnevnik.aop.*")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }

    @Bean
    public AnnotationBeanWiringInfoResolver annotationBeanWiringInfoResolver() {
        return new AnnotationBeanWiringInfoResolver();
    }
}
