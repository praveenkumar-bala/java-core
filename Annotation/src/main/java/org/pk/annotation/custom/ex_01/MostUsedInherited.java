package org.pk.annotation.custom.ex_01;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MostUsedInherited {
    String value() default "Java";
}
