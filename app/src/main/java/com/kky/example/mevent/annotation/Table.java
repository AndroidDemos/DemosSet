package com.kky.example.mevent.annotation;

/*
 * @author Zeus
 * create at 2019/1/14 16:40
 * modify at 2019/1/14 16:40
 * modify because
 * description: TO FIT
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//只能应用于类型上，包括类，接口。
@Retention(RetentionPolicy.RUNTIME)//保存到运行时
public @interface Table {
    String name() default "";
}
