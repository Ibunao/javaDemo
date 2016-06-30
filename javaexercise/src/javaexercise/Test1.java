package javaexercise;

public class Test1 {
	String ding="ding";
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	public void ding(){
		System.out.println(ding);
	}
	class ding{
		public void ding(){
			System.out.println(Test1.this.ding);
		}
	}

}

