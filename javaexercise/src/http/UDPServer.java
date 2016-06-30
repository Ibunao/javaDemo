package http;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * 服务器端，实现基于UDP的用户登录
 * 服务器端早于客户端
 */
public class UDPServer {

	public static void main(String[] args) {
		
		try {
			/*
			 * 服务器端接收客户端的数据
			 */
			//1、创建服务器端DatagramSocket，指定端口
			DatagramSocket socket=new DatagramSocket(8800);
			//2、创建数据报。用于接收客户端的发送的数据
			byte[] data =new byte[1024];//创建字节数组，指定接收的数据包的大小
			DatagramPacket packet=new DatagramPacket(data, data.length);
			//3、接收客户端发送的数据     将数据写入到数据报中
			System.out.println("***服务器端已经启动，等待客户端发送数据***");
			socket.receive(packet);//此方法在接收到数据报之前会一直阻塞
			//4、读取数据
			//将byte数组转换为字符串，从起始位置到数据报的接收长度
			String info=new String(data,0,packet.getLength());
			
			System.out.println("我是服务器，客户端说："+info);
			
			/*
			 * 向客户端响应数据
			 */
			//1、定义客户端的地址、端口号、数据通过packet获取
			//获取客户端的地址
			InetAddress address=packet.getAddress();
			//获取客户端的端口号
			int port=packet.getPort();
			byte[] data2="欢迎您！".getBytes();
			//2、床架你数据报。包含响应的信息
			DatagramPacket packet2=new DatagramPacket(data2, data2.length, address, port);
			//3、响应客户端
			socket.send(packet2);
			
			//关闭相应的资源
			socket.close();
		} catch (SocketException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
