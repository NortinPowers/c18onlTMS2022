package by.tms.config;

import by.tms.aspect.JdbcTemplateExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@ComponentScan("by.tms")
@EnableWebMvc
@PropertySource("classpath:application.properties")
@RequiredArgsConstructor
@EnableAspectJAutoProxy
public class SpringConfig implements WebMvcConfigurer {

    private final Environment environment;

    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("db.driver")));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.login"));
        dataSource.setPassword(environment.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/images/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/css/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/js/");
    }

    @Bean
    public JdbcTemplateExceptionHandler jdbcTemplateExceptionHandler() {
        return new JdbcTemplateExceptionHandler();
    }
}