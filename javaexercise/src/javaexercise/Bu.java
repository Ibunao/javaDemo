package javaexercise;

public class Bu {
	String nao;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int ie=52;
		char c;
		c=(char)ie;
		System.out.println(c);
		//char c='4';
		//int d;
		//d=c;
		//System.out.println(d);
		ding();
		Bu b=new Bu();
		b.ran();
		for(int i=0;i<10;i++){
			if(i==5){
				continue;
			}
			System.out.println(i);
		}
	}
	public static void ding(){
		String bu="ding";
		System.out.println(bu);
	}
	public void ran(){
		String bunao;
		System.out.println(nao);
		
	}
}
