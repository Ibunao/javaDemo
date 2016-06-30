package date;

import java.util.Calendar;
import java.util.Date;

public class CalenderTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Calendar d=Calendar.getInstance();
		int year=d.get(Calendar.YEAR);
		int month=d.get(Calendar.MONTH)+1;
		int day=d.get(Calendar.DAY_OF_MONTH);
		int hour=d.get(Calendar.HOUR_OF_DAY);
		int minute=d.get(Calendar.MINUTE);
		int second=d.get(Calendar.SECOND);
		System.out.println(year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second);
		Date dt=d.getTime();
		System.out.println(dt);
		Long ds=d.getTimeInMillis();
		System.out.println(ds/3600/24/365);
	}

}
