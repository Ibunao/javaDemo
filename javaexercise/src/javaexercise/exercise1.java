package javaexercise;
import java.util.Scanner;


public class exercise1 {
	public static void main(String[] args) {
		int classNu=3;
		byte classStu=4;
		float average=0f;
		Scanner  input=new Scanner(System.in);
		for(int i=1;i<=classNu;i++){
			System.out.println("****��"+i+"���༶");
			int sum=0;
			for(int j=1;j<=classStu;j++){
				
				System.out.println("�������"+j+"��ѧ���ĳɼ�");
				int score=input.nextInt();
				sum+=score;
				
			}
			average=sum/classStu;
			System.out.println(i+"���ƽ���ɼ���"+average);
		}
	}
}
