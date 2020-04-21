package annotion.anno;

/**
 * @Author: shenge
 * @Date: 2020-04-20 10:42
 *
 * 因为注解在使用的时候，所有元素都必须被赋值，但是有时候有些值确实不存在，如何表示呢？一般int就表示为-1，字符串使用空字符串表示。
 */
import java.lang.annotation.*;
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulatingNull {
    int id() default -1;
    String description() default "";
}
