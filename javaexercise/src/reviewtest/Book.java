package reviewtest;

import java.util.Scanner;

public class Book {
	private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String[] books={ "C����", "���ݽṹ", "�������", "����", "��ѧ����", "ë��" };
		String book;
		while (true) {
			System.out.println("�������ѯ��ʽ��1-��ʾ������ѯ��2-��ʾ���кŲ�ѯ");
			try{
			int i=in();
			switch (i) {
			case 1:
				book=bookname(books);
				System.out.println("book:"+book);
				break;
			case 2:
				book=booknum(books);
				System.out.println("book:"+book);
				break;

			default:
				System.out.println("������  1 or 2");
				continue;
			}
			}catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
				continue;
			}
			
		}
	}
	//��ȡ�������ֵ
	public static int in(){
		try{
		input=new Scanner(System.in);//��仰Ϊ�˷�ֹ����Ĳ������ֶ�������ѭ��
		int i=input.nextInt();
		//���û�д�����ĸ�ʽ��int����ִ����һ�䣬����ִ��catch
		return i;
		}catch(Exception e){
			
			return -1;
		}

	}
	public static String bookname(String[]books)throws Exception{
		System.out.println("��������Ҫ��ѯ������");
		
		String name=input.next();
		for (String string : books) {
			if (name.equals(string)) {
				return string;
			}
		}
		//û�еĻ�ֱ���Դ����ӳ�ȥ���Ͳ���Ҫreturn��
		throw new Exception("û�д���");
	}
	public static String booknum(String[]books)throws Exception{
		while(true){
			System.out.println("��������Ҫ��ѯ�����к�");
			try{
			int i=in();
			if (i!=-1) {
				return books[i];
			}
			System.out.println("����������");
			continue;
			}catch(ArrayIndexOutOfBoundsException e){
				Exception bookNotExists = new Exception("ͼ�鲻���ڣ�");
//				bookNotExists.initCause(e);
				throw bookNotExists;
			}
		}
	}

}
