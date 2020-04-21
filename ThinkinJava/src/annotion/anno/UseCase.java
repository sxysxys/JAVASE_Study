package annotion.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: shenge
 * @Date: 2020-04-20 10:11
 *
 * 测试用例注解
 */

@Target(ElementType.METHOD)   //改注解作用在方法上
@Retention(RetentionPolicy.RUNTIME)   //在运行时也存在，所以可以通过反射进行获取相应信息。
public @interface UseCase {   //可以理解为接口，也会生成class文件（如果retention符合的话），里面元素使用方法的形式展现。
    int id();
    String description() default "haha";   //所有元素在使用注解的时候都要被赋值，要不然就得有默认值，不能为null。
}
