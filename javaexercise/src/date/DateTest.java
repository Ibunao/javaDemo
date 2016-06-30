package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Date d=new Date();
		System.out.println(d);
		SimpleDateFormat r=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String b=r.format(d);
		System.out.println(b);
		String n="2016-03-24 09:33:49";
		try {
			Date ing=r.parse(n);
			System.out.println(ing);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
