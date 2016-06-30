package javaexercise;
public class HelloWorld
{
	private String body="ding";
	private static String ran="ran";
	public static void main(String args[]) 
	{
	
	System.out.println("Hello World"+Math.random()*10); 
	HelloWorld ran=new HelloWorld();
	ran.ding();
	String bunao="²»Ø«";
	String bu="²»Ø«";
	System.out.println(bunao.equals(bu));
	}
	public void ding(){
		System.out.println(body);
		System.out.println(ran);
	}
} 