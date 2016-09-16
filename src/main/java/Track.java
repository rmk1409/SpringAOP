import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by r.pogorelov on 16.09.2016.
 */
@Aspect
public class Track {

    //it will be applied on all the methods of ClassWithMethods which starts from 'ms'
    @Before("execution(* ClassWithMethods.ms*(..))")
    public void before(){
        System.out.println("Before method...");
    }

    //it will be applied only on k1 method in ClassWithMethods class
    @After("execution(* ClassWithMethods.k1(..))")
    public void after(JoinPoint point){
        System.out.println("After method...");
    }

    //it will be applied only on methods that returns int value
    @AfterReturning(pointcut = "execution(int ClassWithMethods.*(..))", returning = "res")
    public void afterReturnMethod(JoinPoint point, Object res){
        System.out.println("After returning..., result in method: " + res);
    }

    //only on k2 method
    @Around("execution(* ClassWithMethods.k2(..))")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("Begin around...");
        Object proceed = point.proceed();
        System.out.println("End around..."+proceed);
    }
}
