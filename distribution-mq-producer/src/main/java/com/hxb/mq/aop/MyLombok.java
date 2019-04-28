package com.hxb.mq.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于模拟lombok编译时动态生成代码
 * @author Created by huang xiao bao
 * @date 2019-04-28 11:48:42
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface MyLombok {
    boolean setter() default false;
    boolean getter() default false;
}
