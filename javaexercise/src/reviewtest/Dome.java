package reviewtest;

import java.util.Scanner;

/*
 * ���ܣ�Ϊָ���ĳɼ��ӷ֣�ֱ���������ڵ���60Ϊֹ
 * ����ӷ�ǰ�ĳɼ��ͼӷֺ�ĳɼ�������ͳ�ƼӷֵĴ���
 * ���裺
 * 1.����һ������������ͳ�ƼӷֵĴ���
 * 2.ʹ��ѭ��Ϊ�ɼ��ӷ�
 * 3.ÿ��ִ��ѭ��ʱ��1�֣�����ͳ�ƼӷֵĴ���
 * 
 * ʹ��Scanner����������ȡ�û������ֵ
 * Scanner��λ��java.util���У�ʹ��ʱ��Ҫ����˰�
 * ���裺
 * 1.����java.util.Scanner
 * 2.����Scanner����
 * 3.���ղ������û������ֵ
 */

public class Dome {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input=new Scanner(System.in);
		System.out.println("��������ĳɼ�");
		int score=input.nextInt();
		int count = 0;
		while (score<60) {
			score++;
			count++;
			
		}
		System.out.println("������"+count+"��");
	}

}
