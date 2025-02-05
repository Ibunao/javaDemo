package file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WriteAndReadDemo {

	public static void main(String[] args)throws IOException {
		// TODO 自动生成的方法存根
		File demo=new File("demo\\ding\\ran");//和src相对的位置
		if (!demo.exists()) {
			//没有的话就创建出来
			//只能创建到ding，demo存在
			demo.mkdirs();
			//可以深层创建
			demo.mkdirs();
		}
		//File的拼接
		File file=new File(demo,"raf.dat");
		if(!file.exists())
			
			file.createNewFile();
		RandomAccessFile raf=new RandomAccessFile(file, "rw");
		//指针的位置
		System.out.println(raf.getFilePointer());
		int i=0x7fffffff;//最大的int整型
		//用write方法每次只能写一个字节，如果要把i写进去就需要写4次
		raf.write(i>>>24);//高8位
		raf.write(i>>>16);//次高8位
		raf.write(i>>>8);//次次高8位
		raf.write(i);//低8位
		
	}

}
