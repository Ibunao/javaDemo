package http;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//���һ��inetAddressʵ��      �õ����ص�ַ��ʵ��
		try {
			InetAddress address=InetAddress.getLocalHost();
			System.out.println("������name��"+address.getHostName());
			System.out.println("������IP��"+address.getHostAddress());
			System.out.println("�����ģ�"+address);
			
			//ͨ������/IP���InetAddress����
//			InetAddress address1=InetAddress.getByName("ding");
			InetAddress address1=InetAddress.getByName("192.168.231.2");
			
			System.out.println(""+address1.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
