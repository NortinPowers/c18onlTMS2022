package by.tms.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

    @Pointcut("execution(* by.tms.model.User.printName())")
    public void doAspect() {
    }

/*    @Before("doAspect()")
    public void BeforeAspectDo() {
        System.out.println("Aspect do something BEFORE printName()");
    }*/

/*    @After("doAspect()")
    public void AfterAspectDo() {
        System.out.println("Aspect do something AFTER printName()");
    }*/

    @Around("doAspect()")
    public void AroundAspectDo(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("AroundAspectDo do something BEFORE printName()");
        try {
            proceedingJoinPoint.proceed(); //выполнение метода by.tms.model.User.printName(), требует try-catch
            System.out.println("AroundAspectDo do something AFTER printName()");
        } catch (Throwable throwable) {
            System.out.println("AroundAspectDo do something IF EXCEPTION printName()");
        }
    }
}
