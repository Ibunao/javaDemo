package http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * �����������
 * ����TCPЭ���Socketͨ��,ʵ���û���¼
 * �ͻ���
 */
public class Client {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		try {
			
			//1�������ͻ���Socket��ָ����������ַ�Ͷ˿�
			Socket socket=new Socket("localhost", 8888);
			//2����ȡ���������������˷�����Ϣ
			OutputStream os=socket.getOutputStream();
			//���������װ��Ϊ��ӡ��/���ֽڻ�����һ����
//			PrintWriter pw=new PrintWriter(os);
			BufferedWriter pw=new BufferedWriter(new OutputStreamWriter(os));
			pw.write("�û���:admin;����:123");
			pw.flush();//ˢ�»��棬�������д��
			socket.shutdownOutput();//�ر������
			
			//3����ȡ������������ȡ�������˵���Ӧ��Ϣ
			InputStream is=socket.getInputStream();
			//��װΪ�ַ�������ӻ���
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String info=null;
			while ((info=br.readLine())!=null) {
				System.out.println("���ǿͻ��ˣ�������˵��"+info);
			}
			
			//4���ر���Ӧ����Դ
			br.close();
			is.close();
			
			pw.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}

}
