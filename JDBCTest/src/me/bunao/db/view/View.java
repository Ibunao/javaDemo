package me.bunao.db.view;

import java.util.Scanner;

//��ͼ��
public class View {
	private static final String CONTEXT="��ӭ����Ů��������\n"+
			"������Ů������Ĺ����б���\n"+
			"[MAIN/M]�����˵�\n"+
			"[QUERY/Q]���鿴ȫ��Ů�����Ϣ\n"+
			"[GET/G]���鿴ĳλŮ�����ϸ��Ϣ\n"+
			"[ADD/A]������Ů����Ϣ\n"+
			"[UPDATE/U]������Ů����Ϣ\n"+
			"[DELETE/D]��ɾ��Ů����Ϣ\n"+
			"[SEARCH/S]����ѯŮ����Ϣ(�����������ֻ��ŵ�)\n"+
			"[EXIT/E]���˳�Ů�����\n"+
			"[BREAK/B]���˳���ǰ���ܣ��������˵�\n";
	private static final String OPERATION_MAIN="MAIN";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_GET="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE="UPDATE";
	private static final String OPERATION_DELETE="DELETE";
	private static final String OPERATION_SEARCH="SEARCH";
	private static final String OPERATION_EXIT="EXIT";
	private static final String OPERATION_BREAK="BREAK";
	public static void main(String[] args) {
		System.out.println(CONTEXT);
		Scanner scan=new Scanner(System.in);
		//���屣�ֹ������ı���     ������Ӧ�Ĺ����������Ա���������Ĳ���
		String prenious=null;
		//ͨ����ѭ��������
		while (true) {
			String in=scan.next().toString();
			//������EXIT��eʱ�˳����
			if (OPERATION_EXIT.equals(in.toUpperCase())
					||OPERATION_EXIT.substring(0,1).equals(in.toUpperCase())) {
				System.out.println("���ѳɹ��˳�Ů�����");
				break;
			}else if (OPERATION_ADD.equals(in.toUpperCase())
					||OPERATION_ADD.substring(0,1).equals(in.toUpperCase())
					||OPERATION_ADD.equals(prenious)) {
					prenious=OPERATION_ADD;
					//
					System.out.println("������Ů���[����]��");
					System.out.println("�����Ů�������Ϊ��"+in);
			}else{
				System.out.println("�������ֵΪ��"+in);
			}
		}

	}

}