package listSetMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class setTest {//注意，这个类名不标准，第一个字母没大写
	public List<Course> coursesToSelect;
	public setTest(){
		coursesToSelect=new ArrayList<Course>();
	}
	public Scanner input=new Scanner(System.in);
	//向集合中添加课程
	public void testAdd(){
		//创建一个课程对象，将它放进学生
		Course cr1=new Course(1,"高数");
		//添加方法1，在尾部添加
		coursesToSelect.add(cr1);
		//默认情况下不用泛型的时候list添加对象时，将对象转化为object类型，取出的也是object对象，所以需要进行强转
//		Course temp=(Course) coursesToSelect.get(0);
//		System.out.println("添加了课程：" + temp.id + ":" + temp.name); 
		
		
		//添加方法2 在指定位置添加
		Course cr2=new Course(2,"语文");
		//添加在第一个
		coursesToSelect.add(0, cr2);
//		Course temp1=(Course) coursesToSelect.get(0);
//		System.out.println("添加了课程：" + temp1.id + ":" + temp1.name);
		
		//添加方法3 添加数组
		Course[] cr3={new Course(3,"CAD"),new Course(4,"计算机基础")};
		//将数组传进list必须要用Arrays.aslist
		coursesToSelect.addAll(Arrays.asList(cr3));
//		Course temp2=(Course)coursesToSelect.get(2);
//		Course temp3=(Course)coursesToSelect.get(3);
////		System.out.println("添加了课程：" + temp2.id + ":" + temp2.name);
//		System.out.println("添加了课程：" + temp3.id + ":" + temp3.name);
		
		//添加方法4 在指定位置添加数组
		Course[] cr4={new Course(5,"英语"),new Course(6,"金融")};
		coursesToSelect.addAll(2, Arrays.asList(cr4));
//		Course temp4=(Course)coursesToSelect.get(2);
//		Course temp5=(Course)coursesToSelect.get(3);
//		System.out.println("添加了课程：" + temp4.id + ":" + temp4.name);
//		System.out.println("添加了课程：" + temp5.id + ":" + temp5.name);
		
	}
	
	//for each 遍历
	public void testForEach(){
		//注意，可以使用Course类型，而不是Object,因为使用了泛型
		for(Course cr:coursesToSelect ){
			System.out.println("（foreach）课程：" + cr.id + ":" + cr.name);
		}
	}
	
	/**
	 * 
	 * 测试list集合的contains方法
	 */
	public void testListContains(){
		// 取得备选课程序列的第0个元素
				Course course = coursesToSelect.get(0);
				// 打印输出coursesToSelected是否包含course对象
				System.out.println("取得课程：" + course.name);
				System.out.println("备选课程中是否包含课程：" + course.name + ", " + 
						coursesToSelect.contains(course));
				// 提示输入课程名称
				System.out.println("请输入课程名称：");
				String name = input.next();
				// 创建一个新的课程对象，ID和名称，与course对象完全一样
				//list集合调用contains()方法，contains()方法用的是equal()方法进行的比较，所以要在Course类中重写equal()方法,之比较name
				Course course2 = new Course();
				//只添加name属性，用来查询
				course2.name = name;
				System.out.println("新创建课程：" + course2.name);
				System.out.println("备选课程中是否包含课程：" + course2.name + ", " +
						coursesToSelect.contains(course2));
				// 通过indexOf方法来取得某元素的索引位置，和contains()方法一样也是要用到重写的equal()方法
				if (coursesToSelect.contains(course2))
					System.out.println("课程：" + course2.name + "的索引位置为：" + 
							coursesToSelect.indexOf(course2));
	}
	
	/**
	 * 测试Set的contains方法
	 * set集合使用contains方法，要先比较hashCord然后再用equal，所以这两个方法要重写
	 */
	public void testSetContains() {
		// 提示输入课程名称
		System.out.println("请输入学生已选的课程名称：");
		String name = input.next();
		// 创建一个新的课程对象，ID和名称，与course对象完全一样
		Course course2 = new Course();
		course2.name = name;
		System.out.println("新创建课程：" + course2.name);
		System.out.println("备选课程中是否包含课程：" + course2.name + ", " +
				student.courses.contains(course2));
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		setTest st=new setTest();
		st.testAdd();
		st.testForEach();
		st.selectCourses();
		st.setForEach(student);
		st.testSetContains();
//		st.testListContains();
//		st.selectCourses();
//		st.setForEach(student);
	}
	
	
	public static Student student=new Student("1","小明");
	public void selectCourses(){
//		
//		Scanner input=new Scanner(System.in);
		System.out.println("欢迎"+student.name+"来选课");
		//向set中添加
		//set类型的集合，能添加null值，只不过没有用
		for(int i=0;i<3;i++){
			System.out.println("请输入你要选的课程号:");
			int id=input.nextInt();
			for(Course cr:coursesToSelect){
//				如果是字符串型的则要用equal()方法比较
				if(cr.id==id){
					/**
					 * Set中，添加某个对象，无论添加多少次， 最终只会保留一个该对象（的引用）， 并且，保留的是第一次添加的那一个
					 */
					student.courses.add(cr);
					student.courses.add(cr);
				}
			}
		}
	}
	//遍历student中set集合存储的课程
	//遍历set集合，不能像list集合一样用get()方法遍历，只能用迭代和foreach
	public void setForEach(Student student){
		//用size()方法获得set集合的长度
		System.out.println("你共选择了"+student.courses.size()+"门课");
		for(Course cr:student.courses){
			//因为set集合是无序的，所以每次取出的相同的内容，顺序不太一样
			System.out.println("选择了课程：" + cr.id + ":" + cr.name);
		}
	}

}
