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
 * 基于TCP协议的Socket通信,实现用户登录
 * 服务器端        接收多个客户端
 * 先于客户端启动
 * socket 不论是客户端还是服务器获得的socket对象都是对方的
 */
public class Servers {
	/*
	 * 通过获取输入流来获取客户端的信息
	 * 通过输出流来给客户端传递出信息
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		try {
			
			//1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
			ServerSocket serverSocket=new ServerSocket(8888);
			//2、调用accept方法开始监听同时获得socket对象，等待客户端的链接   
			System.out.println("***服务器即将启动，等待客户端的链接***");
			Socket socket;
			//记录客户端的数量；
			int count=0;
			//实现循环监听   死循环   一直处于监听状体，当收到一个信息将创建一个新的线程
			while (true) {
				//启动对客户端的监听，会一直处于阻塞状态当收到了客户端的请求，才会向下执行
				socket = serverSocket.accept();
				//创建一个新的线程
				ServersThread serverThread=new ServersThread(socket);
				//启动线程，实现与客户端的通讯
				serverThread.start();
				//记录链接客户端的数量
				count++;
				System.out.println("连接客户端的数量："+count);
				//获得当前客户端的Ip
				InetAddress address=socket.getInetAddress();
				System.out.println("当前客户端的IP："+address.getHostAddress());
			}
//			serverSocket.close();//关闭serverSocket    执行不到了
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
