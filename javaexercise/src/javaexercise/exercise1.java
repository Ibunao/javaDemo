package javaexercise;
import java.util.Scanner;


public class exercise1 {
	public static void main(String[] args) {
		int classNu=3;
		byte classStu=4;
		float average=0f;
		Scanner  input=new Scanner(System.in);
		for(int i=1;i<=classNu;i++){
			System.out.println("****第"+i+"个班级");
			int sum=0;
			for(int j=1;j<=classStu;j++){
				
				System.out.println("请输入第"+j+"个学生的成绩");
				int score=input.nextInt();
				sum+=score;
				
			}
			average=sum/classStu;
			System.out.println(i+"班的平均成绩是"+average);
		}
	}
}
