package dididache;
import java.util.*;

public class Dididache {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//���˶�̬   ���Խ������ͷ���һ�������������
		Car[] car={new Aodicar("�µ�",500,4),new Pika("Ƥ��",700,4,3) };
		//Aodicar car1=new Aodicar("�µ�",500,4);
		//System.out.println(car1.money);�ö�̬���޷�������������ֵ�ģ���������ֻ�ܵ������������ֵ;�����ڸ��������get�����õ�����ֵ��Ȼ������������дget����
		//System.out.println(car[1].getMoney());
		System.out.println("��ӭʹ�õεδ�ϵͳ\r\n���Ƿ�Ҫ�⳵��1��2��");
		Scanner input=new Scanner(System.in);
		int in=input.nextInt();
		if(in==1){
			System.out.println("�����⳵�����ͼ����Ŀ��");
			System.out.println("���  "+"   ��������    "+" ���"+"	             ����");
			int i=1;
			for(Car ding:car){//��������
				
				System.out.println(i+"    "+ding.out()); 
				i++;
			}
			System.out.println("��������Ҫ��������������");
//			System.out.println(in);
			int num=input.nextInt();
			int sum=0;
			for(int d=0;d<num;d++){
				System.out.println("�������"+(d+1)+"��������ţ�");
				int j=input.nextInt();
				sum+=car[j-1].getMoney();
				
			}
			System.out.println("������ʹ��������");
			int days=input.nextInt();
			input.close();
			
			System.out.println("�㹲��Ҫ��"+sum*days+"ԪǮ");
			
			
		}
		//Car aodi=new Aodicar("�µ�",500,4);
		//Car pika=new Pika("Ƥ��",500,4,3);
	}

}
