package statictest;
import java.util.Scanner;

public class Statictext {
	public static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		while(true){
			try{
			System.out.println("������");
			int command= input.nextInt();
			System.out.println(command);
			}catch(Exception e){
			System.out.println("������������������ʾ�����������");
			input=new Scanner(System.in);//��try catch �����ʼ�������򽫽�����ѭ��
//			continue;
			}
		}
	}

}
