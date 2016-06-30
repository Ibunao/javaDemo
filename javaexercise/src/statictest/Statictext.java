package statictest;
import java.util.Scanner;

public class Statictext {
	public static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		while(true){
			try{
			System.out.println("请输入");
			int command= input.nextInt();
			System.out.println(command);
			}catch(Exception e){
			System.out.println("命令输入错误！请根据提示输入数字命令！");
			input=new Scanner(System.in);//用try catch 必须初始化，否则将进行死循环
//			continue;
			}
		}
	}

}
