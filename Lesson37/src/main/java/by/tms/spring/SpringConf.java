package by.tms.spring;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("by.tms")
@PropertySource("classpath:spring.properties")
@EnableAspectJAutoProxy
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