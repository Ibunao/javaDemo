package listSetMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestGeneric {
	//泛型的使用< > 泛型只能是对象类型的，不能是基本类型，如果需要基本类型的需要用基本类型相应的包装类如int队形的Integer
	//public List<Integer> coursesToSelect;
	//使用泛型可以保证添加的都是泛型指定的类型或其子类型
	//使用泛型在取出数据的时候取出的直接就是泛型所指定的类型，而不是object类型
	public List<Course> coursesToSelect;
	
	//用构造函数初始化list对象，泛型list对象初始化用ArrayList<泛型>();
	public TestGeneric(){
		this.coursesToSelect=new ArrayList<Course>();
	}
	
	//添加数据
	public void testAdd(){
		//创建一个课程对象，将它放进学生
		Course cr1=new Course(1,"高数");
		//添加方法1，在尾部添加
		coursesToSelect.add(cr1);
		//默认情况下list添加对象时，将对象转化为object类型，取出的也是object对象，所以需要进行强转
		Course temp=(Course) coursesToSelect.get(0);
		System.out.println("添加了课程：" + temp.id + ":" + temp.name); 
		
		
		//添加方法2 在指定位置添加
		Course cr2=new Course(2,"语文");
		//添加在第一个
		coursesToSelect.add(0, cr2);
		Course temp1=(Course) coursesToSelect.get(0);
		System.out.println("添加了课程：" + temp1.id + ":" + temp1.name);
		
		//添加方法3 添加数组
		Course[] cr3={new Course(3,"CAD"),new Course(4,"计算机基础")};
		//将数组传进list必须要用Arrays.aslist
		coursesToSelect.addAll(Arrays.asList(cr3));
		Course temp2=(Course)coursesToSelect.get(2);
		Course temp3=(Course)coursesToSelect.get(3);
		System.out.println("添加了课程：" + temp2.id + ":" + temp2.name);
		System.out.println("添加了课程：" + temp3.id + ":" + temp3.name);
		
		//添加方法4 在指定位置添加数组
		Course[] cr4={new Course(5,"英语"),new Course(6,"金融")};
		coursesToSelect.addAll(2, Arrays.asList(cr4));
		Course temp4=(Course)coursesToSelect.get(2);
		Course temp5=(Course)coursesToSelect.get(3);
		System.out.println("添加了课程：" + temp4.id + ":" + temp4.name);
		System.out.println("添加了课程：" + temp5.id + ":" + temp5.name);
		
	}
	
	//添加子类型
	public void testChild(){
		ChildCourse ccr = new ChildCourse();
		ccr.id = 3;
		ccr.name = "我是子类型的课程对象实例~~";
		coursesToSelect.add(ccr);
	}
	
	//for each 遍历
	public void testForEach(){
		//注意，用的是Course类型，而不是Object,因为使用了泛型
		for(Course cr:coursesToSelect ){
			System.out.println("（foreach）课程：" + cr.id + ":" + cr.name);
		}
	}
	//使用迭代遍历
	public void testIterator(){
		//如果迭代不加<>泛型，则下面依然需要强转
		Iterator<Course> it=coursesToSelect.iterator();
		while(it.hasNext()){
			
			//不能像下面这样用，因为用了两个next()，将向下进行两步4
			//System.out.println("（迭代）课程：" + it.next().id + ":" + it.next().name);
			
			Course cr=it.next();
			System.out.println("（迭代）课程：" + cr.id + ":" + cr.name);
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TestGeneric tg=new TestGeneric();
		tg.testAdd();
		tg.testChild();
		tg.testForEach();
		tg.testIterator();
	}

}
