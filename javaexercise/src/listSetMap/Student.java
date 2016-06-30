package listSetMap;

import java.util.HashSet;
import java.util.Set;


//要让student类进行sort排序，要实现Comparable<Student>接口，并实现CompareTo方法
public class Student implements Comparable<Student> {
	String id;//因为TestMap类中的containValue方法，将其从Int改为String
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
	//默认以id进行排序
	public int compareTo(Student o) {
		// TODO 自动生成的方法存根
		//return 0;
		//默认以id进行排序
		//因为id为String字符串型的，所以已经实现了CompareTo方法
		//返回值为0，1，-1
		return this.id.compareTo(o.id);
	}

	
	
}
