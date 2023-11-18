package org.pk.annotation.custom.ex_03;

import java.lang.annotation.*;

@Repeatable(value = Designations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Designation {
    public String value() default "Employee";
}
