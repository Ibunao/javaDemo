package listSetMap;

public class Course {
	int id;
	String name;
	public Course(int id,String name){
		this.id=id;
		this.name=name;
		
	}
	
	//�����޲ι��캯������������ļ̳�
	public Course(){
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	//ֻ�Ƚ�name����ֵ
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
