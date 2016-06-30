package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Date date=new Date();
		System.out.println(date);
		SimpleDateFormat fo=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println(fo.format(date));
		
		//将字符串形式的时间转换为Date类型
		String n="2016-03-24 09:33:49";
		try {
			Date ing=fo.parse(n);
			System.out.println(ing);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		System.out.println(System.nanoTime());
		System.out.println(System.currentTimeMillis());
	}

}
