package ru.dnevnik.aop.configuration;

import org.springframework.beans.factory.annotation.AnnotationBeanWiringInfoResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ru.dnevnik.aop.repository.BookRepository;

/**
 * @author Kurbatov Gennadii
 * @since 01.11.15
 */
@EnableWebMvc
@ComponentScan("ru.dnevnik.aop.*")
@SpringBootApplication
public class WebConfig extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(WebConfig.class, args);
    }

    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }

    @Bean
    public AnnotationBeanWiringInfoResolver annotationBeanWiringInfoResolver() {
        return new AnnotationBeanWiringInfoResolver();
    }
}
