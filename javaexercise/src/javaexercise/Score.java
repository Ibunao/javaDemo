package javaexercise;
import java.util.Scanner;
public class Score {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner input=new Scanner(System.in);
		System.out.println("请输入成绩");
		int score=input.nextInt();
		input.close();
		int count=0;
		for(;score<60;++count){
			score++;
			//++count;
			//count++;
		}
		System.out.println("共加 了"+count+" 次");
	}

}
