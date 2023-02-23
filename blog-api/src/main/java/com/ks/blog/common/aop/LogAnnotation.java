package com.ks.blog.common.aop;

import java.lang.annotation.*;

// TYPE 代表可以放在类上面 METHOD代表放在方法上
@Target({ElementType.METHOD})
// JVM层面注解
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    String module() default "";

    String operator() default "";
}
