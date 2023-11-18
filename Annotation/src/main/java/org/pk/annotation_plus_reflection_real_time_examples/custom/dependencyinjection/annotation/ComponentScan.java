package org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ComponentScans.class)
public @interface ComponentScan {

    public String value();

}
