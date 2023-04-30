package by.tms.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

    @Pointcut("execution(* by.tms.model.User.printName())")
    public void doAspect() {
    }

    @Pointcut("@annotation(TestAspectAnnotation)")
    public void doAspectAnnotationPointcut() {
    }

    @Before("doAspectAnnotationPointcut()")
    public void beforeAspectDo() {
        System.out.println("AspectAnnotationPointcut do something BEFORE method() with annotation");
    }

    @After("doAspectAnnotationPointcut()")
    public void afterAspectDo() {
        System.out.println("AspectAnnotationPointcut do something AFTER method() with annotation");
    }

    @Around("doAspect()")
    public void aroundAspectDo(ProceedingJoinPoint proceedingJoinPoint) {

        System.out.println("AroundAspectDo do something BEFORE printName()");
        try {
            proceedingJoinPoint.proceed();
            System.out.println("AroundAspectDo do something AFTER printName()");
        } catch (Throwable throwable) {
            System.out.println("AroundAspectDo do something IF EXCEPTION printName()");
        }
    }
}