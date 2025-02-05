package dao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})  //定义注解作用域  ，作用在类上
@Retention(RetentionPolicy.RUNTIME) //声明周期，表示运行时存在可以通过反射读取
public @interface Table {
	String value();
}
