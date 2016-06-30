package book;

import java.io.InputStream;
import java.util.Scanner;

public class Book {
	private static String[] books={ "C语言", "数据结构", "汇编语言", "高数", "大学语文", "毛概" };
	private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		while (true) {
			try {
				System.out.println("请输入查询方式：1-表示书名查询，2-表示序列号查询");
				int index=receivenu();
				switch (index) {
				case 1:
					queryBook();
					break;
				case 2:
					queryNum();
					break;
				case -1:
					System.out.println("不要调皮捣蛋，输入数字");
					continue;

				default:
					System.out.println("抱歉，只能输入1或2");
					continue;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				//捕捉到异常就没办法继续执行了循环了
//				continue;//要他也没用
			}
			
		}
		
	}
	//接收数据的方法
	public static int receivenu(){
		try {
			int index=input.nextInt();
			return index;
		} catch (Exception e) {
			System.out.println("输入的不是数字");
			//重新声明       清空     不然会造成死循环
			input=new Scanner(System.in);
			return -1;
		}
	}
	//根据书名进行查询
	public static String queryBook() throws Exception{
		String book=null;
		System.out.println("请输入你要查询的书名");
		book=input.next();
		for (int i = 0; i < books.length; i++) {
			if (books[i].equals(book)) {
				System.out.println("有这本书");
				return book;
			}
			
		}
		//如果循环完没有找到这本书，则通过异常进行抛出，让接收到异常的进行处理
		throw new Exception("没有此图书");
		
	}
	//通过序列号进行查询
	public static String queryNum() throws Exception{
		System.out.println("请输入你要查询的序列号");
		int index =receivenu();
		if (index>=0&&index<books.length) {
			System.out.println("有这本书");
			return books[index];
		}
		throw new Exception("没有此图书");
	}

}
