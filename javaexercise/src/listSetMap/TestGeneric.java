package listSetMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestGeneric {
	//���͵�ʹ��< > ����ֻ���Ƕ������͵ģ������ǻ������ͣ������Ҫ�������͵���Ҫ�û���������Ӧ�İ�װ����int���ε�Integer
	//public List<Integer> coursesToSelect;
	//ʹ�÷��Ϳ��Ա�֤��ӵĶ��Ƿ���ָ�������ͻ���������
	//ʹ�÷�����ȡ�����ݵ�ʱ��ȡ����ֱ�Ӿ��Ƿ�����ָ�������ͣ�������object����
	public List<Course> coursesToSelect;
	
	//�ù��캯����ʼ��list���󣬷���list�����ʼ����ArrayList<����>();
	public TestGeneric(){
		this.coursesToSelect=new ArrayList<Course>();
	}
	
	//�������
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
	
	//���������
	public void testChild(){
		ChildCourse ccr = new ChildCourse();
		ccr.id = 3;
		ccr.name = "���������͵Ŀγ̶���ʵ��~~";
		coursesToSelect.add(ccr);
	}
	
	//for each ����
	public void testForEach(){
		//ע�⣬�õ���Course���ͣ�������Object,��Ϊʹ���˷���
		for(Course cr:coursesToSelect ){
			System.out.println("��foreach���γ̣�" + cr.id + ":" + cr.name);
		}
	}
	//ʹ�õ�������
	public void testIterator(){
		//�����������<>���ͣ���������Ȼ��Ҫǿת
		Iterator<Course> it=coursesToSelect.iterator();
		while(it.hasNext()){
			
			//���������������ã���Ϊ��������next()�������½�������4
			//System.out.println("���������γ̣�" + it.next().id + ":" + it.next().name);
			
			Course cr=it.next();
			System.out.println("���������γ̣�" + cr.id + ":" + cr.name);
		}
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		TestGeneric tg=new TestGeneric();
		tg.testAdd();
		tg.testChild();
		tg.testForEach();
		tg.testIterator();
	}

}
