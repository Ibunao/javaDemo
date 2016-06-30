package file;

import java.io.File;

public class FileUtils{
	/*
	 * 列出指定目录下（包括其子目录）的所有文件
	 */
	public static void listDirectory(File dir) throws Exception{
		if (!dir.exists()) {
			throw new IllegalArgumentException("传入的"+dir+"不存在");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException("传入的"+dir+"不是目录");
		}
//		String[] filenames=dir.list();//获取子目录及文件
//		for (String string : filenames) {
//			System.out.println(dir+"\\"+string);
//		}
		File[] files=dir.listFiles();
		if (files!=null&&files.length>0) {
			for (File file : files) {
				if (file.isDirectory()) {
					//递归
					listDirectory(file);
				}else{
					
					System.out.println(file);
				}
			}
		}
		
	}
}
