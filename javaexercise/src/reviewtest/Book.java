package reviewtest;

import java.util.Scanner;

public class Book {
	private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String[] books={ "C语言", "数据结构", "汇编语言", "高数", "大学语文", "毛概" };
		String book;
		while (true) {
			System.out.println("请输入查询方式：1-表示书名查询，2-表示序列号查询");
			try{
			int i=in();
			switch (i) {
			case 1:
				book=bookname(books);
				System.out.println("book:"+book);
				break;
			case 2:
				book=booknum(books);
				System.out.println("book:"+book);
				break;

			default:
				System.out.println("请输入  1 or 2");
				continue;
			}
			}catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
				continue;
			}
			
		}
	}
	//获取输入的数值
	public static int in(){
		try{
		input=new Scanner(System.in);//这句话为了防止输入的不是数字而出现死循环
		int i=input.nextInt();
		//如果没有错输入的格式是int型则执行下一句，否则执行catch
		return i;
		}catch(Exception e){
			
			return -1;
		}

	}
	public static String bookname(String[]books)throws Exception{
		System.out.println("请输入你要查询的书名");
		
		String name=input.next();
		for (String string : books) {
			if (name.equals(string)) {
				return string;
			}
		}
		//没有的话直接以错误扔出去，就不需要return了
		throw new Exception("没有此书");
	}
	public static String booknum(String[]books)throws Exception{
		while(true){
			System.out.println("请输入你要查询的序列号");
			try{
			int i=in();
			if (i!=-1) {
				return books[i];
			}
			System.out.println("请输入数字");
			continue;
			}catch(ArrayIndexOutOfBoundsException e){
				Exception bookNotExists = new Exception("图书不存在！");
//				bookNotExists.initCause(e);
				throw bookNotExists;
			}
		}
	}

}
