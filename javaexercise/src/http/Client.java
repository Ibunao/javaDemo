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
 * 先启动服务端
 * 基于TCP协议的Socket通信,实现用户登录
 * 客户端
 */
public class Client {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		try {
			
			//1、创建客户端Socket，指定服务器地址和端口
			Socket socket=new Socket("localhost", 8888);
			//2、获取输出流，向服务器端发送信息
			OutputStream os=socket.getOutputStream();
			//将输出流包装成为打印流/和字节缓冲流一样吧
//			PrintWriter pw=new PrintWriter(os);
			BufferedWriter pw=new BufferedWriter(new OutputStreamWriter(os));
			pw.write("用户名:admin;密码:123");
			pw.flush();//刷新缓存，向服务器写入
			socket.shutdownOutput();//关闭输出流
			
			//3、获取输入流，并读取服务器端的相应信息
			InputStream is=socket.getInputStream();
			//包装为字符流并添加缓存
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String info=null;
			while ((info=br.readLine())!=null) {
				System.out.println("我是客户端，服务器说："+info);
			}
			
			//4、关闭相应的资源
			br.close();
			is.close();
			
			pw.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
