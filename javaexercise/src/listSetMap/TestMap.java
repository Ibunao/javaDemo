package listSetMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TestMap {
//注意，使用的是int类型对应的包装类，因为泛型不支持基础类型
	public Map<String,Student> student;
	public TestMap(){
		this.student=new HashMap<String,Student>();
	}
	
	//输入
	Scanner input=new Scanner(System.in);
	public void testIn(){
		for(int i=0;i<3;i++){
			System.out.println("清输入要添加的Id");
			String id=input.next();
			if(student.get(id)==null){
				System.out.println("请输入要添加的姓名：");
				String name=input.next();
				Student stu=new Student(id,name);
				student.put(id, stu);
				System.out.println("添加成功"+student.get(id).name);
				
			}else{
				System.out.println("所输入的id已存在：");
				continue;
			}
		}
	}
	
	//用keyset遍历map
	//keyset 获得的是键值的集合
	public void testKeySet(){
		Set<String> keySet=student.keySet();
		//用size（）方法获得长度
		System.out.println("共有"+keySet.size()+"个同学");
		for(String id:keySet){
			System.out.println(student.get(id).name);
		}
	}
	
	//用Entryset遍历map
	//entrySet()方法得到的是Entry对象    集 合，entry对象是键值对的形式
	public void testEntrySet(){
		//注意这个形式，因为student规定了泛型，这里添加泛型的时候要将他们带上
		Set<Entry<String,Student>> entrySet=student.entrySet();
		for(Entry<String, Student> entry:entrySet){
			//取得键值
			System.out.print("id:"+entry.getKey());
			//取得值
			System.out.println("    name:"+entry.getValue().name);
		}
	}
	
	
	//删除
	public void testRemove(){
		while(true){
			System.out.println("请输入要删除的id");
			Integer id=input.nextInt();
			if(student.get(id)==null){
				System.out.println("不存在这个id");
				continue;
			}else{
				System.out.println("删除成功"+student.get(id).name);
				student.remove(id);
				break;
			}
		}
	}
	
	//修改  利用put方法修改Map中的已有映射
	public void testModify(){
		while(true){
			System.out.println("请输入要修改的id");
			String id=input.next();
			if(student.get(id)==null){
				System.out.println("抱歉，没有你要修改的id");
				continue;
				
			}else{
				System.out.println("修改前的名字"+student.get(id).name);
				System.out.println("请输入你想修该成的名字");
				String name=input.next();
				Student stu=new Student(id,name);
				student.put(id, stu);
				System.out.println("修改成功");
				break;
			}
		
		}
	}
	
	/**
	 * containsKey()  containsValue
	 * 测试Map中，是否包含某个Key值或者某个Value值
	 * 注意，重写equal时不能将key（id）重写，因为是String类型的不是其他对象型
	 * *需要重写是因为传进取得是对象类型的，而不用重写的传入的是字符串或基本数据类型的
	 * 用到containsValue时需要重写，但是只用containsKey方法是不用重写
	 * 如果id是int型的如何查询name
	 */
	public void testContainsKeyOrValue() {
		// 提示输入学生id
		System.out.println("请输入要查询的学生ID：");
		Scanner console = new Scanner(System.in);
		String id = console.next();
		// 在Map中，用containsKey()方法，来判断是否包含某个Key值
		System.out.println("您输入的学生ID为：" + id + "，在学生映射表中是否存在："
				+ student.containsKey(id));
		if (student.containsKey(id))
			System.out.println("对应的学生为：" + student.get(id).name);
		// 提示输入学生姓名
		System.out.println("请输入要查询的学生姓名：");
		String name = console.next();
		// 用containsValue()方法，来判断是否包含某个Value值
		if (student.containsValue(new Student(null,name)))
			System.out.println("在学生映射表中，确实包含学生：" + name);
		else
			System.out.println("在学生映射表中不存在该学生！");
	}
	
	public static void main(String[] args){
		TestMap tm=new TestMap();
		tm.testIn();
//		tm.testKeySet();
//		tm.testRemove();
//		tm.testKeySet();
		tm.testEntrySet();
		tm.testModify();
		tm.testEntrySet();
		tm.testContainsKeyOrValue();
	}
}
