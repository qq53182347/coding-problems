package 自定义注解;

import java.lang.annotation.*;

/**
 * 水果名称注解
 * @author peida
 *
 */
@Target(value={ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface FruitName  {
	String value() default "";
}
