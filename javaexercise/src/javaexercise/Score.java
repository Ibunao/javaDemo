package javaexercise;
import java.util.Scanner;
public class Score {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input=new Scanner(System.in);
		System.out.println("������ɼ�");
		int score=input.nextInt();
		input.close();
		int count=0;
		for(;score<60;++count){
			score++;
			//++count;
			//count++;
		}
		System.out.println("���� ��"+count+" ��");
	}

}
