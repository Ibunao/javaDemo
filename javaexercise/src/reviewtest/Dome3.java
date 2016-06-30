package reviewtest;

public class Dome3 {
	static String ding;
	static String ran;
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		ding="丁冉";
//		ran="丁冉";
//		System.out.println(ding.equals(ran));
//		Animal animal=new Animal();
		Animal animal=new Dog();
		Dog dog=(Dog) animal;
		System.out.println(dog.name);
	}
	

}
