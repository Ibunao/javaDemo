package reviewtest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Dome0 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		Date date=new Date();
//		System.out.println(date);
//		SimpleDateFormat sdf=new SimpleDateFormat("yy-DD-MM");
//		System.out.println(sdf.format(date));
//		Calendar c=Calendar.getInstance();
//		int year=c.get(Calendar.YEAR);
		List<Integer>list=new ArrayList<>();
		list.add(1);
		Integer[] intarr={2,3,4};
		list.addAll(Arrays.asList(intarr));
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//			
//		}
//		Iterator<Integer> d=list.iterator();
//		while (d.hasNext()) {
//			System.out.println(d.next());
//			
//		}
//		for (Integer integer : list) {
//			System.out.println(integer);
//		}
		System.out.println(list.contains(2));
		System.out.println(list.indexOf(3));
		List<String>list1=new ArrayList<>();
		list1.add("丁冉");
		list1.add("丁晓");
		String[] string={"不孬","张雪芳","王昊","刘陈磊"};
		list1.addAll(Arrays.asList(string));
		for (String integer : list1) {
			System.out.println(integer);
		}
		System.out.println(list1.indexOf("王昊"));
		System.out.println(list1.contains("丁冉"));
	}

}
