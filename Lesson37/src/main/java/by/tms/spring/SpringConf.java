package by.tms.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("by.tms")
@PropertySource("classpath:spring.properties")
@EnableAspectJAutoProxy
@RequiredArgsConstructor
public class SpringConf {

    private final Environment environment;

    @Bean
    public String name() {
        return environment.getProperty("name");
    }
}