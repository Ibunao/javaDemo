package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ����TCPЭ���Socketͨ��,ʵ���û���¼
 * ��������      ����һ���ͻ���
 * ���ڿͻ�������
 */
public class Server {
	/*
	 * ͨ����ȡ����������ȡ�ͻ��˵���Ϣ
	 * ͨ������������ͻ��˴��ݳ���Ϣ
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		try {
			
			//1������һ����������Socket����ServerSocket��ָ���󶨵Ķ˿ڣ��������˶˿�
			ServerSocket serverSocket=new ServerSocket(8888);
			//2������accept������ʼ����ͬʱ���socket���󣬵ȴ��ͻ��˵�����   
			System.out.println("***�����������������ȴ��ͻ��˵�����***");
			Socket socket = serverSocket.accept();
			//3����ȡ�ֽ�������������ȡ�ͻ�����Ϣ
			InputStream is = socket.getInputStream();
			//���ֽ���ת��Ϊ�ַ���
			InputStreamReader isr=new InputStreamReader(is);
			//��ӻ���
			BufferedReader br=new BufferedReader(isr);
			//ѭ����ȡ�ͻ��˵���Ϣ
			String info=null;
			while ((info=br.readLine())!=null) {
				System.out.println("���Ƿ��������ͻ���˵��"+info);
			}
			//4����ȡ���������Ӧ�ͻ��˵����󣬺Ϳͻ��˵ķ�����Ϣ����
			OutputStream os = socket.getOutputStream();
			//��װ�ɴ�ӡ��
			PrintWriter pw = new PrintWriter(os);
			//��Ӧ�ͻ��˵�����
			pw.write("��ӭ����");
			//ˢ�»���    Ҫ����
			pw.flush();
			
			//5���ر���Ӧ����Դ
			socket.shutdownInput();//�ر�������
			pw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();//�ر�socket
			serverSocket.close();//�ر�serverSocket
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
