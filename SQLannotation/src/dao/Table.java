package dao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})  //����ע��������  ������������
@Retention(RetentionPolicy.RUNTIME) //�������ڣ���ʾ����ʱ���ڿ���ͨ�������ȡ
public @interface Table {
	String value();
}
