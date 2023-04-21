package by.tms.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class PageExceptionInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //NOT WORKING
        int status = response.getStatus();
        if (status >= 400) {
            if (response.getStatus() == 404) {
                log.error("Page not found: {}", request.getRequestURL());
                response.sendRedirect("/404");
            } else {
                response.sendRedirect("/some-error");
                log.error("Unexpected exception: {}", request.getRequestURL());
            }
        }
    }
}
