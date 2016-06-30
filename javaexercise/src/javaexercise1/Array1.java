package javaexercise1;


public class Array1 {
	static int[] array3;
	static int ding=1;
	static{
	    array3[1]=10;
	    array3[0]=11;
	}//为什么必须写在初始化块中，写在初始化块中也是错误的
	public static void main(String[] args) {
		System.out.println(array3);
	}
}
