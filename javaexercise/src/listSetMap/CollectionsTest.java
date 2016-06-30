package listSetMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 将要完成：
 * 1.通过Collections.sort()方法，对Integer泛型的List进行排序；
 * 2.对String泛型的List进行排序；
 * 3.对其他类型泛型的List进行排序，以Student为例。
 */
public class CollectionsTest {

	
	/**
	 * 1.通过Collections.sort()方法，对Integer泛型的List进行排序；
	 * 创建一个Integer泛型的List，插入十个100以内的不重复随机整数，
	 * 调用Collections.sort()方法对其进行排序
	 */
	public void testSort1(){
		List<Integer> intsort=new ArrayList<Integer>();
		// 插入十个100以内的不重复随机整数
		Random random =new Random();
		Integer k;
		for(int i=0;i<10;i++){
			//需要先生成，然后进行比较的，就可以用do while
			do{
				k=random.nextInt(100);
			}while(intsort.contains(k));
			intsort.add(k);
			System.out.println("成功添加"+k);
		}
		System.out.println("-----------排序前-------------");
		for(Integer d:intsort){
			System.out.println(d);
		}
		
		Collections.sort(intsort);
		System.out.println("-----------排序后-------------");
		for(Integer d:intsort){
			System.out.println(d);
		}
	}
	
	/**
	 * 2.对String泛型的List进行排序；
	 * 创建String泛型的List，添加三个随机生成的String元素，
	 * 调用sort方法，再次输出排序后的顺序
	 * 
	 * 生成随机的字符串，生成数字然后将数字转为对应得字符,需要更精确的就需要知道字母的范围
	 */
	public void testSort2(){
		List<String> strSort=new ArrayList<String>();
		
		Character ding = null;
		Random random=new Random();
		//生成字符长度为5的字符串
		for(int d=0;d<3;d++){
			String ran = null;
			for(int i=0;i<5;i++){
				//因为不能将char强转成String,所以用他的包装类
				//随机生成大小写字母
				//2表示可以生成0，1
				int r=random.nextInt(2);
	//			System.out.println(r);
				if(r==0){
					ding=(char) (random.nextInt(25)+65);
				}else{
					ding=(char) (random.nextInt(25)+97);
				}
				if(ran==null){
					ran=ding.toString();
				}else{
					ran=ran+ding;
				}
			}
			strSort.add(ran);
			System.out.println("添加成功"+ran);
		}
		System.out.println("-----------排序前-------------");
		for(String d:strSort){
			System.out.println(d);
		}
		
		Collections.sort(strSort);
		System.out.println("-----------排序后-------------");
		for(String d:strSort){
			System.out.println(d);
		}
		 
		
	}
	

	/**
	 * 3.对其他类型泛型的List进行排序，以Student为例。
	 */
	public void testSort3(){
		List<Student> studentList = new ArrayList<Student>();
		Random random = new Random();
		studentList.add(new Student(random.nextInt(1000) + "", "Mike"));
		studentList.add(new Student(random.nextInt(1000) + "", "Angela"));
		studentList.add(new Student(random.nextInt(1000) + "", "Lucy"));
		studentList.add(new Student(10000 + "", "Beyonce"));
		System.out.println("--------------排序前---------------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.id + ":" + student.name);
		}
		//要实现对象的比较，Student类要实现Comparable接口
		Collections.sort(studentList);
		System.out.println("----------------排序后------------------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.id + ":" + student.name);
		}
		
		//使用临时排序对name排序
		//使用继承了Comparator接口的StudentComparator类
		Collections.sort(studentList, new StudentComparator());
		System.out.println("----------------按照姓名排序后-----------------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.id + ":" + student.name);
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		CollectionsTest ct=new CollectionsTest();
//		ct.testSort1();
		ct.testSort2();
		ct.testSort3();
	}

}
