package book;

import java.io.InputStream;
import java.util.Scanner;

public class Book {
	private static String[] books={ "C����", "���ݽṹ", "�������", "����", "��ѧ����", "ë��" };
	private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		while (true) {
			try {
				System.out.println("�������ѯ��ʽ��1-��ʾ������ѯ��2-��ʾ���кŲ�ѯ");
				int index=receivenu();
				switch (index) {
				case 1:
					queryBook();
					break;
				case 2:
					queryNum();
					break;
				case -1:
					System.out.println("��Ҫ��Ƥ��������������");
					continue;

				default:
					System.out.println("��Ǹ��ֻ������1��2");
					continue;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				//��׽���쳣��û�취����ִ����ѭ����
//				continue;//Ҫ��Ҳû��
			}
			
		}
		
	}
	//�������ݵķ���
	public static int receivenu(){
		try {
			int index=input.nextInt();
			return index;
		} catch (Exception e) {
			System.out.println("����Ĳ�������");
			//��������       ���     ��Ȼ�������ѭ��
			input=new Scanner(System.in);
			return -1;
		}
	}
	//�����������в�ѯ
	public static String queryBook() throws Exception{
		String book=null;
		System.out.println("��������Ҫ��ѯ������");
		book=input.next();
		for (int i = 0; i < books.length; i++) {
			if (books[i].equals(book)) {
				System.out.println("���Ȿ��");
				return book;
			}
			
		}
		//���ѭ����û���ҵ��Ȿ�飬��ͨ���쳣�����׳����ý��յ��쳣�Ľ��д���
		throw new Exception("û�д�ͼ��");
		
	}
	//ͨ�����кŽ��в�ѯ
	public static String queryNum() throws Exception{
		System.out.println("��������Ҫ��ѯ�����к�");
		int index =receivenu();
		if (index>=0&&index<books.length) {
			System.out.println("���Ȿ��");
			return books[index];
		}
		throw new Exception("û�д�ͼ��");
	}

}
