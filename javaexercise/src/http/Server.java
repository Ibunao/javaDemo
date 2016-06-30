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
 * 基于TCP协议的Socket通信,实现用户登录
 * 服务器端      接收一个客户端
 * 先于客户端启动
 */
public class Server {
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
			Socket socket = serverSocket.accept();
			//3、获取字节输入流，并读取客户端信息
			InputStream is = socket.getInputStream();
			//将字节流转换为字符流
			InputStreamReader isr=new InputStreamReader(is);
			//添加缓冲
			BufferedReader br=new BufferedReader(isr);
			//循环读取客户端的信息
			String info=null;
			while ((info=br.readLine())!=null) {
				System.out.println("我是服务器，客户端说："+info);
			}
			//4、获取输出流，相应客户端的请求，和客户端的发送信息相似
			OutputStream os = socket.getOutputStream();
			//包装成打印流
			PrintWriter pw = new PrintWriter(os);
			//相应客户端的请求
			pw.write("欢迎您！");
			//刷新缓存    要发送
			pw.flush();
			
			//5、关闭相应的资源
			socket.shutdownInput();//关闭输入流
			pw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();//关闭socket
			serverSocket.close();//关闭serverSocket
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
