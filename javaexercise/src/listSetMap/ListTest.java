package listSetMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public List coursesToSelect;//创建List对象
	//利用构造函数对List对象用ArrayList初始化
	public ListTest(){
		this.coursesToSelect=new ArrayList();
	}
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
	
	/**
	 * 取得list中所有元素的方法
	 * @param args
	 */
	//方法一
	public void testGet(){
		//用size方法取得list的长度
		int size=coursesToSelect.size();
		for(int i=0;i<size;i++){
			Course cr=(Course) coursesToSelect.get(i);
			System.out.println("课程：" + cr.id + ":" + cr.name);
		}
	}
	//方法2 用迭代器来遍历list
	public void testIterator(){
		//通过集合的iterator方法得到迭代器的实例
		//如果list没有添加泛型，迭代也不能添加泛型<>
		Iterator it=coursesToSelect.iterator();
		System.out.println("下面通过迭代器进行遍历");
		while(it.hasNext()){
			Course cr=(Course)it.next();
			System.out.println("（迭代）课程：" + cr.id + ":" + cr.name);
			
		}
	}
	//方法3 用for  each遍历
	public void testForEach(){
		for(Object obj:coursesToSelect){//如果不用范类取出的为object类型的对象
			Course cr=(Course)obj;
			System.out.println("（foreach）课程：" + cr.id + ":" + cr.name);
		}
	}
	
	
	//修改list中的元素
	public void testSet(){
		coursesToSelect.set(3, new Course(7,"大金融"));
		
	}
	
	//删除list中的元素
	//和添加相似
	public void testRemove(){
		//方法一
		//coursesToSelect.remove(3);
		
		//方法二
		//Course cr=(Course)coursesToSelect.get(3);
		//coursesToSelect.remove(cr);
		
		//方法三
		Course[] course={(Course)coursesToSelect.get(4),(Course)coursesToSelect.get(5)};
		coursesToSelect.removeAll(Arrays.asList(course));
		
	}
	
	
	//添加非Course对象的东西
	public void testType(){
		//插入成功，但是取出来的时候会发现出现问题，因为这不符合集合
		//集合为了是将相似的存在一块
		//这就是要用泛型的原因，使用泛型，则只能插入泛型制定的类型及其子类型
		coursesToSelect.add("丁冉");
		System.out.println("加入成功");
	}
	
	
	public static void main(String[] args) {
//		 TODO 自动生成的方法存根
		ListTest lt=new ListTest();
		lt.testAdd();
//		lt.testType();
//		lt.testGet();
//		lt.testIterator();
//		
//		lt.testSet();
//		lt.testRemove();
		lt.testForEach();
	}

}
