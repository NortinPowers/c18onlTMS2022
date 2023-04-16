package by.tms.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class JdbcTemplateExceptionHandler {

    @AfterThrowing(pointcut = "execution(* by.tms.repository.*.*(..))", throwing = "ex")
    public void handleException(JoinPoint joinPoint, Exception ex) {
        log.error("Exception occurred in method: " + joinPoint.getSignature().getName() + ", exception message: " + ex.getMessage());
    }
}