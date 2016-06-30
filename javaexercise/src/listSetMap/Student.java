package listSetMap;

import java.util.HashSet;
import java.util.Set;


//Ҫ��student�����sort����Ҫʵ��Comparable<Student>�ӿڣ���ʵ��CompareTo����
public class Student implements Comparable<Student> {
	String id;//��ΪTestMap���е�containValue�����������Int��ΪString
	String name;
	public Set<Course> courses;
	public Student(String id,String name){
		this.id=id;
		this.name=name;
		this.courses=new HashSet<Course>();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	//Ĭ����id��������
	public int compareTo(Student o) {
		// TODO �Զ����ɵķ������
		//return 0;
		//Ĭ����id��������
		//��ΪidΪString�ַ����͵ģ������Ѿ�ʵ����CompareTo����
		//����ֵΪ0��1��-1
		return this.id.compareTo(o.id);
	}

	
	
}
