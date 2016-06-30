package http;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * �������ˣ�ʵ�ֻ���UDP���û���¼
 * �����������ڿͻ���
 */
public class UDPServer {

	public static void main(String[] args) {
		
		try {
			/*
			 * �������˽��տͻ��˵�����
			 */
			//1��������������DatagramSocket��ָ���˿�
			DatagramSocket socket=new DatagramSocket(8800);
			//2���������ݱ������ڽ��տͻ��˵ķ��͵�����
			byte[] data =new byte[1024];//�����ֽ����飬ָ�����յ����ݰ��Ĵ�С
			DatagramPacket packet=new DatagramPacket(data, data.length);
			//3�����տͻ��˷��͵�����     ������д�뵽���ݱ���
			System.out.println("***���������Ѿ��������ȴ��ͻ��˷�������***");
			socket.receive(packet);//�˷����ڽ��յ����ݱ�֮ǰ��һֱ����
			//4����ȡ����
			//��byte����ת��Ϊ�ַ���������ʼλ�õ����ݱ��Ľ��ճ���
			String info=new String(data,0,packet.getLength());
			
			System.out.println("���Ƿ��������ͻ���˵��"+info);
			
			/*
			 * ��ͻ�����Ӧ����
			 */
			//1������ͻ��˵ĵ�ַ���˿ںš�����ͨ��packet��ȡ
			//��ȡ�ͻ��˵ĵ�ַ
			InetAddress address=packet.getAddress();
			//��ȡ�ͻ��˵Ķ˿ں�
			int port=packet.getPort();
			byte[] data2="��ӭ����".getBytes();
			//2�����������ݱ���������Ӧ����Ϣ
			DatagramPacket packet2=new DatagramPacket(data2, data2.length, address, port);
			//3����Ӧ�ͻ���
			socket.send(packet2);
			
			//�ر���Ӧ����Դ
			socket.close();
		} catch (SocketException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
