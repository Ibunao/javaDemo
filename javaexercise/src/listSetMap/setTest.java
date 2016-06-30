package listSetMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class setTest {//ע�⣬�����������׼����һ����ĸû��д
	public List<Course> coursesToSelect;
	public setTest(){
		coursesToSelect=new ArrayList<Course>();
	}
	public Scanner input=new Scanner(System.in);
	//�򼯺�����ӿγ�
	public void testAdd(){
		//����һ���γ̶��󣬽����Ž�ѧ��
		Course cr1=new Course(1,"����");
		//��ӷ���1����β�����
		coursesToSelect.add(cr1);
		//Ĭ������²��÷��͵�ʱ��list��Ӷ���ʱ��������ת��Ϊobject���ͣ�ȡ����Ҳ��object����������Ҫ����ǿת
//		Course temp=(Course) coursesToSelect.get(0);
//		System.out.println("����˿γ̣�" + temp.id + ":" + temp.name); 
		
		
		//��ӷ���2 ��ָ��λ�����
		Course cr2=new Course(2,"����");
		//����ڵ�һ��
		coursesToSelect.add(0, cr2);
//		Course temp1=(Course) coursesToSelect.get(0);
//		System.out.println("����˿γ̣�" + temp1.id + ":" + temp1.name);
		
		//��ӷ���3 �������
		Course[] cr3={new Course(3,"CAD"),new Course(4,"���������")};
		//�����鴫��list����Ҫ��Arrays.aslist
		coursesToSelect.addAll(Arrays.asList(cr3));
//		Course temp2=(Course)coursesToSelect.get(2);
//		Course temp3=(Course)coursesToSelect.get(3);
////		System.out.println("����˿γ̣�" + temp2.id + ":" + temp2.name);
//		System.out.println("����˿γ̣�" + temp3.id + ":" + temp3.name);
		
		//��ӷ���4 ��ָ��λ���������
		Course[] cr4={new Course(5,"Ӣ��"),new Course(6,"����")};
		coursesToSelect.addAll(2, Arrays.asList(cr4));
//		Course temp4=(Course)coursesToSelect.get(2);
//		Course temp5=(Course)coursesToSelect.get(3);
//		System.out.println("����˿γ̣�" + temp4.id + ":" + temp4.name);
//		System.out.println("����˿γ̣�" + temp5.id + ":" + temp5.name);
		
	}
	
	//for each ����
	public void testForEach(){
		//ע�⣬����ʹ��Course���ͣ�������Object,��Ϊʹ���˷���
		for(Course cr:coursesToSelect ){
			System.out.println("��foreach���γ̣�" + cr.id + ":" + cr.name);
		}
	}
	
	/**
	 * 
	 * ����list���ϵ�contains����
	 */
	public void testListContains(){
		// ȡ�ñ�ѡ�γ����еĵ�0��Ԫ��
				Course course = coursesToSelect.get(0);
				// ��ӡ���coursesToSelected�Ƿ����course����
				System.out.println("ȡ�ÿγ̣�" + course.name);
				System.out.println("��ѡ�γ����Ƿ�����γ̣�" + course.name + ", " + 
						coursesToSelect.contains(course));
				// ��ʾ����γ�����
				System.out.println("������γ����ƣ�");
				String name = input.next();
				// ����һ���µĿγ̶���ID�����ƣ���course������ȫһ��
				//list���ϵ���contains()������contains()�����õ���equal()�������еıȽϣ�����Ҫ��Course������дequal()����,֮�Ƚ�name
				Course course2 = new Course();
				//ֻ���name���ԣ�������ѯ
				course2.name = name;
				System.out.println("�´����γ̣�" + course2.name);
				System.out.println("��ѡ�γ����Ƿ�����γ̣�" + course2.name + ", " +
						coursesToSelect.contains(course2));
				// ͨ��indexOf������ȡ��ĳԪ�ص�����λ�ã���contains()����һ��Ҳ��Ҫ�õ���д��equal()����
				if (coursesToSelect.contains(course2))
					System.out.println("�γ̣�" + course2.name + "������λ��Ϊ��" + 
							coursesToSelect.indexOf(course2));
	}
	
	/**
	 * ����Set��contains����
	 * set����ʹ��contains������Ҫ�ȱȽ�hashCordȻ������equal����������������Ҫ��д
	 */
	public void testSetContains() {
		// ��ʾ����γ�����
		System.out.println("������ѧ����ѡ�Ŀγ����ƣ�");
		String name = input.next();
		// ����һ���µĿγ̶���ID�����ƣ���course������ȫһ��
		Course course2 = new Course();
		course2.name = name;
		System.out.println("�´����γ̣�" + course2.name);
		System.out.println("��ѡ�γ����Ƿ�����γ̣�" + course2.name + ", " +
				student.courses.contains(course2));
	}
	
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
	
	
	public static Student student=new Student("1","С��");
	public void selectCourses(){
//		
//		Scanner input=new Scanner(System.in);
		System.out.println("��ӭ"+student.name+"��ѡ��");
		//��set�����
		//set���͵ļ��ϣ������nullֵ��ֻ����û����
		for(int i=0;i<3;i++){
			System.out.println("��������Ҫѡ�Ŀγ̺�:");
			int id=input.nextInt();
			for(Course cr:coursesToSelect){
//				������ַ����͵���Ҫ��equal()�����Ƚ�
				if(cr.id==id){
					/**
					 * Set�У����ĳ������������Ӷ��ٴΣ� ����ֻ�ᱣ��һ���ö��󣨵����ã��� ���ң��������ǵ�һ����ӵ���һ��
					 */
					student.courses.add(cr);
					student.courses.add(cr);
				}
			}
		}
	}
	//����student��set���ϴ洢�Ŀγ�
	//����set���ϣ�������list����һ����get()����������ֻ���õ�����foreach
	public void setForEach(Student student){
		//��size()�������set���ϵĳ���
		System.out.println("�㹲ѡ����"+student.courses.size()+"�ſ�");
		for(Course cr:student.courses){
			//��Ϊset����������ģ�����ÿ��ȡ������ͬ�����ݣ�˳��̫һ��
			System.out.println("ѡ���˿γ̣�" + cr.id + ":" + cr.name);
		}
	}

}
