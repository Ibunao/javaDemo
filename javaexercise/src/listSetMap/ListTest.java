package listSetMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public List coursesToSelect;//����List����
	//���ù��캯����List������ArrayList��ʼ��
	public ListTest(){
		this.coursesToSelect=new ArrayList();
	}
	public void testAdd(){
		//����һ���γ̶��󣬽����Ž�ѧ��
		Course cr1=new Course(1,"����");
		//��ӷ���1����β�����
		coursesToSelect.add(cr1);
		//Ĭ�������list��Ӷ���ʱ��������ת��Ϊobject���ͣ�ȡ����Ҳ��object����������Ҫ����ǿת
		Course temp=(Course) coursesToSelect.get(0);
		System.out.println("����˿γ̣�" + temp.id + ":" + temp.name); 
		
		
		//��ӷ���2 ��ָ��λ�����
		Course cr2=new Course(2,"����");
		//����ڵ�һ��
		coursesToSelect.add(0, cr2);
		Course temp1=(Course) coursesToSelect.get(0);
		System.out.println("����˿γ̣�" + temp1.id + ":" + temp1.name);
		
		//��ӷ���3 �������
		Course[] cr3={new Course(3,"CAD"),new Course(4,"���������")};
		//�����鴫��list����Ҫ��Arrays.aslist
		coursesToSelect.addAll(Arrays.asList(cr3));
		Course temp2=(Course)coursesToSelect.get(2);
		Course temp3=(Course)coursesToSelect.get(3);
		System.out.println("����˿γ̣�" + temp2.id + ":" + temp2.name);
		System.out.println("����˿γ̣�" + temp3.id + ":" + temp3.name);
		
		//��ӷ���4 ��ָ��λ���������
		Course[] cr4={new Course(5,"Ӣ��"),new Course(6,"����")};
		coursesToSelect.addAll(2, Arrays.asList(cr4));
		Course temp4=(Course)coursesToSelect.get(2);
		Course temp5=(Course)coursesToSelect.get(3);
		System.out.println("����˿γ̣�" + temp4.id + ":" + temp4.name);
		System.out.println("����˿γ̣�" + temp5.id + ":" + temp5.name);
		
	}
	
	/**
	 * ȡ��list������Ԫ�صķ���
	 * @param args
	 */
	//����һ
	public void testGet(){
		//��size����ȡ��list�ĳ���
		int size=coursesToSelect.size();
		for(int i=0;i<size;i++){
			Course cr=(Course) coursesToSelect.get(i);
			System.out.println("�γ̣�" + cr.id + ":" + cr.name);
		}
	}
	//����2 �õ�����������list
	public void testIterator(){
		//ͨ�����ϵ�iterator�����õ���������ʵ��
		//���listû����ӷ��ͣ�����Ҳ������ӷ���<>
		Iterator it=coursesToSelect.iterator();
		System.out.println("����ͨ�����������б���");
		while(it.hasNext()){
			Course cr=(Course)it.next();
			System.out.println("���������γ̣�" + cr.id + ":" + cr.name);
			
		}
	}
	//����3 ��for  each����
	public void testForEach(){
		for(Object obj:coursesToSelect){//������÷���ȡ����Ϊobject���͵Ķ���
			Course cr=(Course)obj;
			System.out.println("��foreach���γ̣�" + cr.id + ":" + cr.name);
		}
	}
	
	
	//�޸�list�е�Ԫ��
	public void testSet(){
		coursesToSelect.set(3, new Course(7,"�����"));
		
	}
	
	//ɾ��list�е�Ԫ��
	//���������
	public void testRemove(){
		//����һ
		//coursesToSelect.remove(3);
		
		//������
		//Course cr=(Course)coursesToSelect.get(3);
		//coursesToSelect.remove(cr);
		
		//������
		Course[] course={(Course)coursesToSelect.get(4),(Course)coursesToSelect.get(5)};
		coursesToSelect.removeAll(Arrays.asList(course));
		
	}
	
	
	//��ӷ�Course����Ķ���
	public void testType(){
		//����ɹ�������ȡ������ʱ��ᷢ�ֳ������⣬��Ϊ�ⲻ���ϼ���
		//����Ϊ���ǽ����ƵĴ���һ��
		//�����Ҫ�÷��͵�ԭ��ʹ�÷��ͣ���ֻ�ܲ��뷺���ƶ������ͼ���������
		coursesToSelect.add("��Ƚ");
		System.out.println("����ɹ�");
	}
	
	
	public static void main(String[] args) {
//		 TODO �Զ����ɵķ������
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
