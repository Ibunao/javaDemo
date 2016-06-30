package date;

import java.util.Calendar;
import java.util.Date;

public class CalenderTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONDAY)+1;
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int hour=cal.get(Calendar.HOUR_OF_DAY);
		int minute=cal.get(Calendar.MINUTE);
		int second=cal.get(Calendar.SECOND);
		System.out.println(year+"/"+month+"/"+day+"  "+hour+":"+minute+":"+second);
		Date date= cal.getTime();
		System.out.println(date);
		Long ds=cal.getTimeInMillis();
		System.out.println(ds/3600/24/365);
	}

}
