package reviewtest;

public class Dome3 {
	static String ding;
	static String ran;
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
//		ding="��Ƚ";
//		ran="��Ƚ";
//		System.out.println(ding.equals(ran));
//		Animal animal=new Animal();
		Animal animal=new Dog();
		Dog dog=(Dog) animal;
		System.out.println(dog.name);
	}
	

}
