import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by r.pogorelov on 16.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appContextConfig.xml");
        ClassWithMethods bean = (ClassWithMethods) context.getBean("classWithMethods");

        bean.k1();
        bean.k2();
        bean.k3();

        int x = bean.m();
        System.out.println(x);

        bean.msg1();
        bean.msg2();
        bean.msg3();
    }
}
