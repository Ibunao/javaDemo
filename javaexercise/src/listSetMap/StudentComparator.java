package listSetMap;

import java.util.Comparator;
//�̳�Comparator�ӿڵ��࣬����Ҫ��Student����ΪҪ�Ƚ�Student���͵�
//������򣬰���name��������
public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO �Զ����ɵķ������
		//return 0;
		//����name��������nameΪString���ͣ�ʵ����compareTo����
		//compareTo������ʵ��Ĭ�ϱȽ�Comparable�ӿڵķ���
		//����ֵ��0��-1��1
		return o1.name.compareTo(o2.name);
	}
	
}
