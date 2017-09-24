package customAnnotation;

import java.lang.annotation.*;
/**
 * 水果颜色注解
 * @author peida
 *
 */
@Target(value={ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface FruitColor  {
	
    /**
     * 颜色属性
     * @return
     */
    Color fruitColor() default Color.GREEN;
}
