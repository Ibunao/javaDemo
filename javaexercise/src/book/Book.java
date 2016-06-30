package book;
import java.util.Scanner;

public class Book {
	public static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String[] books={ "C语言", "数据结构", "汇编语言", "高数", "大学语文", "毛概" };
		
		String book;
		while(true){
			try{
			System.out.println("请输入查询方式：1-表示书名查询，2-表示序列号查询");
			int i;
			i=receivenu();
			switch(i){
			case 1:
				//System.out.println("请输入你要查询的书名");
				book=bookname(books);
				System.out.println("book:"+book);
				break;
			case 2:
				System.out.println("请输入你要查询的序列号");
				book=booknum(books);
				System.out.println("book:"+book);
				break;
			case -1:
				System.out.println("请输入数字");
				continue;
			default:
				System.out.println("对不起你输入的不是1或2");
				continue;
			}
			}catch(Exception a){
				System.out.println(a.getMessage());
				//a.printStackTrace();//显示异常信息
				
//				continue;
			}
		}
	}
	//接受数据
	public static int receivenu(){
		try{
			int num=input.nextInt();
			//如果没有错输入的格式是int型则执行下一句，否则执行catch
			return num;
		}catch(Exception e){
			System.out.println("输入的不是数字");
			input=new Scanner(System.in);//不初始化，如果输入的不是数字将出现死循环
			return -1;
		}
	}
	//书名查询
	public static String bookname(String[] name)throws Exception {
		System.out.println("请输入书名：");
		String getname;
		getname=input.next();
		for(int i=0;i<name.length;i++){
			if(getname.equals(name[i])){
				return name[i];
			}
			
		}
		//没有的话直接以错误扔出去，就不需要return了
		throw new Exception("没有此图书");//
	}
	//序列号查询
	public static String booknum(String[] name)throws Exception {
		while(true){
			System.out.println("请输入序列号：");
			try{
				int innum=receivenu();
				if(innum!=-1){
					String b=name[innum];
					return b;
				}else{
					System.out.println("请输入数字");
					continue;
				}
				
			}catch(ArrayIndexOutOfBoundsException e){
				Exception bookNotExists = new Exception("图书不存在！");
				//bookNotExists.initCause(e);
				throw bookNotExists;
			}
		}
	}

}
