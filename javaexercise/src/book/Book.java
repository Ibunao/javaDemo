package book;
import java.util.Scanner;

public class Book {
	public static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String[] books={ "C����", "���ݽṹ", "�������", "����", "��ѧ����", "ë��" };
		
		String book;
		while(true){
			try{
			System.out.println("�������ѯ��ʽ��1-��ʾ������ѯ��2-��ʾ���кŲ�ѯ");
			int i;
			i=receivenu();
			switch(i){
			case 1:
				//System.out.println("��������Ҫ��ѯ������");
				book=bookname(books);
				System.out.println("book:"+book);
				break;
			case 2:
				System.out.println("��������Ҫ��ѯ�����к�");
				book=booknum(books);
				System.out.println("book:"+book);
				break;
			case -1:
				System.out.println("����������");
				continue;
			default:
				System.out.println("�Բ���������Ĳ���1��2");
				continue;
			}
			}catch(Exception a){
				System.out.println(a.getMessage());
				//a.printStackTrace();//��ʾ�쳣��Ϣ
				
//				continue;
			}
		}
	}
	//��������
	public static int receivenu(){
		try{
			int num=input.nextInt();
			//���û�д�����ĸ�ʽ��int����ִ����һ�䣬����ִ��catch
			return num;
		}catch(Exception e){
			System.out.println("����Ĳ�������");
			input=new Scanner(System.in);//����ʼ�����������Ĳ������ֽ�������ѭ��
			return -1;
		}
	}
	//������ѯ
	public static String bookname(String[] name)throws Exception {
		System.out.println("������������");
		String getname;
		getname=input.next();
		for(int i=0;i<name.length;i++){
			if(getname.equals(name[i])){
				return name[i];
			}
			
		}
		//û�еĻ�ֱ���Դ����ӳ�ȥ���Ͳ���Ҫreturn��
		throw new Exception("û�д�ͼ��");//
	}
	//���кŲ�ѯ
	public static String booknum(String[] name)throws Exception {
		while(true){
			System.out.println("���������кţ�");
			try{
				int innum=receivenu();
				if(innum!=-1){
					String b=name[innum];
					return b;
				}else{
					System.out.println("����������");
					continue;
				}
				
			}catch(ArrayIndexOutOfBoundsException e){
				Exception bookNotExists = new Exception("ͼ�鲻���ڣ�");
				//bookNotExists.initCause(e);
				throw bookNotExists;
			}
		}
	}

}
