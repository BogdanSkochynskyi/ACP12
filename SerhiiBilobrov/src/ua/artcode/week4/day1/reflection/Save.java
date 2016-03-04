package ua.artcode.week4.day1.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Save {

    // name = "sdfsd"
    String name() default "";

    int order() default -1;
    // primitive, immutable(String), enum
    String[] formats() default {};

}
