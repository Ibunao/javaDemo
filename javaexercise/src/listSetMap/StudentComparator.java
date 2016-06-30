package listSetMap;

import java.util.Comparator;
//继承Comparator接口的类，泛型要用Student是因为要比较Student类型的
//排序规则，按照name进行排序
public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO 自动生成的方法存根
		//return 0;
		//按照name进行排序，name为String类型，实现了compareTo方法
		//compareTo方法是实现默认比较Comparable接口的方法
		//返回值是0，-1，1
		return o1.name.compareTo(o2.name);
	}
	
}
