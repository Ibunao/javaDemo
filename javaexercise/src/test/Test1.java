package test;

import java.io.RandomAccessFile;

public class Test1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//		String ding="丁";
//		System.out.println(ding.getBytes()[1]);
//		char c='4';
//		int d;
//		d=c;
//		System.out.println(d);
//		String e;
//		e=c+"";
//		d=Integer.parseInt(e); 
//		c=(char) d;
//		System.out.println(d);
//		System.out.println(c);
		String ding="dingran";
		String ran=new String("dingran");
		System.out.println("dingran".equals(ding)+"----"+
		("dingran".equals(ran))+"----"+("dingran"==ding)+
		"----"+("dingran"==ran)
		+"----"+(ding==ran)
		+"----"+(ding.equals(ran))
				);
		
		
	}

}
