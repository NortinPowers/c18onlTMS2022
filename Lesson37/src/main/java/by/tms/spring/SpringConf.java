package by.tms.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("by.tms.model")
@PropertySource("classpath:spring.properties")
public class SpringConf {

    final
    Environment environment;

    public SpringConf(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public String name() {
        return environment.getProperty("name");
    }
}