package http;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//获得一个inetAddress实例      得到本地地址的实例
		try {
			InetAddress address=InetAddress.getLocalHost();
			System.out.println("本机的name："+address.getHostName());
			System.out.println("本机的IP："+address.getHostAddress());
			System.out.println("本机的："+address);
			
			//通过名字/IP获得InetAddress对象
//			InetAddress address1=InetAddress.getByName("ding");
			InetAddress address1=InetAddress.getByName("192.168.231.2");
			
			System.out.println(""+address1.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
