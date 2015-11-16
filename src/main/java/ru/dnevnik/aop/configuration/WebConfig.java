package ru.dnevnik.aop.configuration;

import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ru.dnevnik.aop.annotation.Loggable;
import ru.dnevnik.aop.repository.BookRepository;
import ru.dnevnik.aop.spring.AroundAdvice;
import ru.dnevnik.aop.spring.BeforeAdvice;

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
    public AnnotationMatchingPointcut loggablePointcut() {
        return new AnnotationMatchingPointcut(Loggable.class);
    }

    @Bean
    public NameMatchMethodPointcut nameMatchMethodPointcut() {
        NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
        nameMatchMethodPointcut.setMappedNames("putBook", "getBook");
        return nameMatchMethodPointcut;
    }

    @Bean
    public AroundAdvice aroundAdvice() {
        return new AroundAdvice();
    }

    @Bean
    public BeforeAdvice beforeAdvice() {
        return new BeforeAdvice();
    }

    @Bean
    public PointcutAdvisor beforePointcutAdvisor() {
        return new DefaultPointcutAdvisor(loggablePointcut(), beforeAdvice());
    }

    @Bean
    public PointcutAdvisor aroundPointcutAdvisor() {
        return new DefaultPointcutAdvisor(nameMatchMethodPointcut(), aroundAdvice());
    }
}
