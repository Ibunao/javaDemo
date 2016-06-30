package reviewtest;

public class Dome2 {
//	static int a;
//	//初始化块
//	static{
//		a=4;
//		System.out.println(a);
////		fff();
//	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		System.out.println(a);
		Dome2 dome=new Dome2();
//		System.out.println(this);
		dome.fff();
	}
	public void fff(){
		System.out.println(this);
		if(true){
			System.out.println(Dome2.this);
		}
//		System.out.println("初始化完成");
	}

}
