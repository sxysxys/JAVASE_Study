package annotion.handle;

import annotion.anno.UseCase;
import annotion.use.PasswordUtils;

import java.lang.reflect.Method;

/**
 * @Author: shenge
 * @Date: 2020-04-20 10:26
 *
 * UseCase处理器：通过反射拿到传入的信息。
 */
public class UseCaseTracker {
    public static void trackUseCases(Class<?> cl){
        for (Method method : cl.getMethods()) {
            UseCase u1 = method.getAnnotation(UseCase.class);
            if (u1!=null)
            System.out.println(u1.id()+"::"+u1.description());
        }
    }

    public static void main(String[] args) {
        trackUseCases(PasswordUtils.class);
    }
}
