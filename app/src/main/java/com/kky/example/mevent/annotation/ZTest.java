package com.kky.example.mevent.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @author Zeus
 * create at 2019/1/14 16:38
 * modify at 2019/1/14 16:38
 * modify because
 * description: 自定义注解
 */
//标记Annotation:无成员变量，只利用自身是否存在来提供信息。
@Target(ElementType.METHOD)//只能应用于方法上。
@Retention(RetentionPolicy.RUNTIME)//保存到运行时
public @interface ZTest {

}
