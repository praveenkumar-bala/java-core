package org.pk.annotation.custom.ex_01;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MostUsed {


    String value() default "Java";

}
