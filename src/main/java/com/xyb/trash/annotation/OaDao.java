/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by xieyunbo on 2018/5/3.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface OaDao {
    String value() default "";
}
