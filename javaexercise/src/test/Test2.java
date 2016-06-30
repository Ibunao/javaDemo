package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Test2 {

	public static void main(String[] args) {
		File file=new File("D:\\qycache\\ding\\ding.txt");
		File file1=new File("D:"+File.separator+"qycache");
		System.out.println(file.isDirectory());
//		System.out.println(file.exists());
//		System.out.println(file.delete());
		System.out.println(file.isFile());//为什么为false
		System.out.println(file1.getName()+"  "+file1.getParent());
		File file2=new File("D:\\qycache\\ding\\ran.txt");
		try {
			file2.createNewFile();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		File file3=new File("D:\\qycache\\ding");
		File[] files=file3.listFiles();
		for (File file4 : files) {
			if (file4.isDirectory()) {
				System.out.println(file4.getAbsolutePath());
			}
		}
		//InputStream是一个抽象类，没有办法实例化
//		InputStream in=new InputStream(file2);
		try {
			//文件内容123456789
			FileInputStream in=new FileInputStream(file2);
			int b;
			int i=1;
			byte[] buf=new byte[7];
			while ((b=in.read(buf,0,buf.length))!=-1) {
				System.out.println(b);
				for (int j = 0; j < b; j++) {
					System.out.println(buf[j]);
					
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
