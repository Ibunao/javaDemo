package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ����TCPЭ���Socketͨ��,ʵ���û���¼
 * ��������        ���ն���ͻ���
 * ���ڿͻ�������
 * socket �����ǿͻ��˻��Ƿ�������õ�socket�����ǶԷ���
 */
public class Servers {
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
			Socket socket;
			//��¼�ͻ��˵�������
			int count=0;
			//ʵ��ѭ������   ��ѭ��   һֱ���ڼ���״�壬���յ�һ����Ϣ������һ���µ��߳�
			while (true) {
				//�����Կͻ��˵ļ�������һֱ��������״̬���յ��˿ͻ��˵����󣬲Ż�����ִ��
				socket = serverSocket.accept();
				//����һ���µ��߳�
				ServersThread serverThread=new ServersThread(socket);
				//�����̣߳�ʵ����ͻ��˵�ͨѶ
				serverThread.start();
				//��¼���ӿͻ��˵�����
				count++;
				System.out.println("���ӿͻ��˵�������"+count);
				//��õ�ǰ�ͻ��˵�Ip
				InetAddress address=socket.getInetAddress();
				System.out.println("��ǰ�ͻ��˵�IP��"+address.getHostAddress());
			}
//			serverSocket.close();//�ر�serverSocket    ִ�в�����
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
