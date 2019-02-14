package org.mybatis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: ICL
 * Date:2019/2/14
 * Description: 主键注解
 * Created by ICL on 2019/2/14.
 */
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PrimaryKey {
    String  value() default "";
}
