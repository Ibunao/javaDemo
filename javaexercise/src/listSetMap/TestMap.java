package listSetMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TestMap {
//ע�⣬ʹ�õ���int���Ͷ�Ӧ�İ�װ�࣬��Ϊ���Ͳ�֧�ֻ�������
	public Map<String,Student> student;
	public TestMap(){
		this.student=new HashMap<String,Student>();
	}
	
	//����
	Scanner input=new Scanner(System.in);
	public void testIn(){
		for(int i=0;i<3;i++){
			System.out.println("������Ҫ��ӵ�Id");
			String id=input.next();
			if(student.get(id)==null){
				System.out.println("������Ҫ��ӵ�������");
				String name=input.next();
				Student stu=new Student(id,name);
				student.put(id, stu);
				System.out.println("��ӳɹ�"+student.get(id).name);
				
			}else{
				System.out.println("�������id�Ѵ��ڣ�");
				continue;
			}
		}
	}
	
	//��keyset����map
	//keyset ��õ��Ǽ�ֵ�ļ���
	public void testKeySet(){
		Set<String> keySet=student.keySet();
		//��size����������ó���
		System.out.println("����"+keySet.size()+"��ͬѧ");
		for(String id:keySet){
			System.out.println(student.get(id).name);
		}
	}
	
	//��Entryset����map
	//entrySet()�����õ�����Entry����    �� �ϣ�entry�����Ǽ�ֵ�Ե���ʽ
	public void testEntrySet(){
		//ע�������ʽ����Ϊstudent�涨�˷��ͣ�������ӷ��͵�ʱ��Ҫ�����Ǵ���
		Set<Entry<String,Student>> entrySet=student.entrySet();
		for(Entry<String, Student> entry:entrySet){
			//ȡ�ü�ֵ
			System.out.print("id:"+entry.getKey());
			//ȡ��ֵ
			System.out.println("    name:"+entry.getValue().name);
		}
	}
	
	
	//ɾ��
	public void testRemove(){
		while(true){
			System.out.println("������Ҫɾ����id");
			Integer id=input.nextInt();
			if(student.get(id)==null){
				System.out.println("���������id");
				continue;
			}else{
				System.out.println("ɾ���ɹ�"+student.get(id).name);
				student.remove(id);
				break;
			}
		}
	}
	
	//�޸�  ����put�����޸�Map�е�����ӳ��
	public void testModify(){
		while(true){
			System.out.println("������Ҫ�޸ĵ�id");
			String id=input.next();
			if(student.get(id)==null){
				System.out.println("��Ǹ��û����Ҫ�޸ĵ�id");
				continue;
				
			}else{
				System.out.println("�޸�ǰ������"+student.get(id).name);
				System.out.println("�����������޸óɵ�����");
				String name=input.next();
				Student stu=new Student(id,name);
				student.put(id, stu);
				System.out.println("�޸ĳɹ�");
				break;
			}
		
		}
	}
	
	/**
	 * containsKey()  containsValue
	 * ����Map�У��Ƿ����ĳ��Keyֵ����ĳ��Valueֵ
	 * ע�⣬��дequalʱ���ܽ�key��id����д����Ϊ��String���͵Ĳ�������������
	 * *��Ҫ��д����Ϊ����ȡ���Ƕ������͵ģ���������д�Ĵ�������ַ���������������͵�
	 * �õ�containsValueʱ��Ҫ��д������ֻ��containsKey�����ǲ�����д
	 * ���id��int�͵���β�ѯname
	 */
	public void testContainsKeyOrValue() {
		// ��ʾ����ѧ��id
		System.out.println("������Ҫ��ѯ��ѧ��ID��");
		Scanner console = new Scanner(System.in);
		String id = console.next();
		// ��Map�У���containsKey()���������ж��Ƿ����ĳ��Keyֵ
		System.out.println("�������ѧ��IDΪ��" + id + "����ѧ��ӳ������Ƿ���ڣ�"
				+ student.containsKey(id));
		if (student.containsKey(id))
			System.out.println("��Ӧ��ѧ��Ϊ��" + student.get(id).name);
		// ��ʾ����ѧ������
		System.out.println("������Ҫ��ѯ��ѧ��������");
		String name = console.next();
		// ��containsValue()���������ж��Ƿ����ĳ��Valueֵ
		if (student.containsValue(new Student(null,name)))
			System.out.println("��ѧ��ӳ����У�ȷʵ����ѧ����" + name);
		else
			System.out.println("��ѧ��ӳ����в����ڸ�ѧ����");
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
