package by.tms.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.tms.model")
public class SpringConf {

    @Bean
    public String name() {
        return "Hello";
    }
}