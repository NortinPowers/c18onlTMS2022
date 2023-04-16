package by.tms.config;

import lombok.NonNull;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class EshopDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                SpringConfig.class
        };
    }

    @Override
    protected String @NonNull [] getServletMappings() {
        return new String[]{
                "/"
        };
    }
}