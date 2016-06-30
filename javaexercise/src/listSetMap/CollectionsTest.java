package listSetMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * ��Ҫ��ɣ�
 * 1.ͨ��Collections.sort()��������Integer���͵�List��������
 * 2.��String���͵�List��������
 * 3.���������ͷ��͵�List����������StudentΪ����
 */
public class CollectionsTest {

	
	/**
	 * 1.ͨ��Collections.sort()��������Integer���͵�List��������
	 * ����һ��Integer���͵�List������ʮ��100���ڵĲ��ظ����������
	 * ����Collections.sort()���������������
	 */
	public void testSort1(){
		List<Integer> intsort=new ArrayList<Integer>();
		// ����ʮ��100���ڵĲ��ظ��������
		Random random =new Random();
		Integer k;
		for(int i=0;i<10;i++){
			//��Ҫ�����ɣ�Ȼ����бȽϵģ��Ϳ�����do while
			do{
				k=random.nextInt(100);
			}while(intsort.contains(k));
			intsort.add(k);
			System.out.println("�ɹ����"+k);
		}
		System.out.println("-----------����ǰ-------------");
		for(Integer d:intsort){
			System.out.println(d);
		}
		
		Collections.sort(intsort);
		System.out.println("-----------�����-------------");
		for(Integer d:intsort){
			System.out.println(d);
		}
	}
	
	/**
	 * 2.��String���͵�List��������
	 * ����String���͵�List���������������ɵ�StringԪ�أ�
	 * ����sort�������ٴ����������˳��
	 * 
	 * ����������ַ�������������Ȼ������תΪ��Ӧ���ַ�,��Ҫ����ȷ�ľ���Ҫ֪����ĸ�ķ�Χ
	 */
	public void testSort2(){
		List<String> strSort=new ArrayList<String>();
		
		Character ding = null;
		Random random=new Random();
		//�����ַ�����Ϊ5���ַ���
		for(int d=0;d<3;d++){
			String ran = null;
			for(int i=0;i<5;i++){
				//��Ϊ���ܽ�charǿת��String,���������İ�װ��
				//������ɴ�Сд��ĸ
				//2��ʾ��������0��1
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
			System.out.println("��ӳɹ�"+ran);
		}
		System.out.println("-----------����ǰ-------------");
		for(String d:strSort){
			System.out.println(d);
		}
		
		Collections.sort(strSort);
		System.out.println("-----------�����-------------");
		for(String d:strSort){
			System.out.println(d);
		}
		 
		
	}
	

	/**
	 * 3.���������ͷ��͵�List����������StudentΪ����
	 */
	public void testSort3(){
		List<Student> studentList = new ArrayList<Student>();
		Random random = new Random();
		studentList.add(new Student(random.nextInt(1000) + "", "Mike"));
		studentList.add(new Student(random.nextInt(1000) + "", "Angela"));
		studentList.add(new Student(random.nextInt(1000) + "", "Lucy"));
		studentList.add(new Student(10000 + "", "Beyonce"));
		System.out.println("--------------����ǰ---------------");
		for (Student student : studentList) {
			System.out.println("ѧ����" + student.id + ":" + student.name);
		}
		//Ҫʵ�ֶ���ıȽϣ�Student��Ҫʵ��Comparable�ӿ�
		Collections.sort(studentList);
		System.out.println("----------------�����------------------");
		for (Student student : studentList) {
			System.out.println("ѧ����" + student.id + ":" + student.name);
		}
		
		//ʹ����ʱ�����name����
		//ʹ�ü̳���Comparator�ӿڵ�StudentComparator��
		Collections.sort(studentList, new StudentComparator());
		System.out.println("----------------�������������-----------------");
		for (Student student : studentList) {
			System.out.println("ѧ����" + student.id + ":" + student.name);
		}
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		CollectionsTest ct=new CollectionsTest();
//		ct.testSort1();
		ct.testSort2();
		ct.testSort3();
	}

}
