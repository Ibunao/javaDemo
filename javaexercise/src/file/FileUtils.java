package file;

import java.io.File;

public class FileUtils{
	/*
	 * �г�ָ��Ŀ¼�£���������Ŀ¼���������ļ�
	 */
	public static void listDirectory(File dir) throws Exception{
		if (!dir.exists()) {
			throw new IllegalArgumentException("�����"+dir+"������");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException("�����"+dir+"����Ŀ¼");
		}
//		String[] filenames=dir.list();//��ȡ��Ŀ¼���ļ�
//		for (String string : filenames) {
//			System.out.println(dir+"\\"+string);
//		}
		File[] files=dir.listFiles();
		if (files!=null&&files.length>0) {
			for (File file : files) {
				if (file.isDirectory()) {
					//�ݹ�
					listDirectory(file);
				}else{
					
					System.out.println(file);
				}
			}
		}
		
	}
}
