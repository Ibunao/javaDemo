package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Date date=new Date();
		System.out.println(date);
		SimpleDateFormat fo=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println(fo.format(date));
		
		//���ַ�����ʽ��ʱ��ת��ΪDate����
		String n="2016-03-24 09:33:49";
		try {
			Date ing=fo.parse(n);
			System.out.println(ing);
		} catch (ParseException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		System.out.println(System.nanoTime());
		System.out.println(System.currentTimeMillis());
	}

}
