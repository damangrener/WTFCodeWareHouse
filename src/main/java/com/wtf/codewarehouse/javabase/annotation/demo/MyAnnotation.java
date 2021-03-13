package com.wtf.codewarehouse.javabase.annotation.demo;

import java.lang.annotation.*;

/**
 * 用来获取方法中的参数
 * @Author: WTF
 * @Date: 2021/1/26 19:23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface MyAnnotation {

    String json();

}
