package file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WriteAndReadDemo {

	public static void main(String[] args)throws IOException {
		// TODO �Զ����ɵķ������
		File demo=new File("demo\\ding\\ran");//��src��Ե�λ��
		if (!demo.exists()) {
			//û�еĻ��ʹ�������
			//ֻ�ܴ�����ding��demo����
			demo.mkdirs();
			//������㴴��
			demo.mkdirs();
		}
		//File��ƴ��
		File file=new File(demo,"raf.dat");
		if(!file.exists())
			
			file.createNewFile();
		RandomAccessFile raf=new RandomAccessFile(file, "rw");
		//ָ���λ��
		System.out.println(raf.getFilePointer());
		int i=0x7fffffff;//����int����
		//��write����ÿ��ֻ��дһ���ֽڣ����Ҫ��iд��ȥ����Ҫд4��
		raf.write(i>>>24);//��8λ
		raf.write(i>>>16);//�θ�8λ
		raf.write(i>>>8);//�δθ�8λ
		raf.write(i);//��8λ
		
	}

}