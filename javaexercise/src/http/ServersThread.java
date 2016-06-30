package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServersThread extends Thread {
	Socket socket;
	public ServersThread(Socket sc) {
		// TODO 自动生成的构造函数存根
		this.socket=sc;
	}
	@Override
	public void run() {
//		// TODO 自动生成的方法存根
//		super.run();
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			//获取字节输入流，并读取客户端信息
			is = socket.getInputStream();
			//将字节流转换为字符流
			isr=new InputStreamReader(is);
			//添加缓冲
			br=new BufferedReader(isr);
			//循环读取客户端的信息
			String info=null;
			while ((info=br.readLine())!=null) {
				System.out.println("我是服务器，客户端说："+info);
			}
			//获取输出流，相应客户端的请求，和客户端的发送信息相似
			os = socket.getOutputStream();
			//包装成打印流
			pw = new PrintWriter(os);
			//相应客户端的请求
			pw.write("欢迎您！");
			//刷新缓存    要发送
			pw.flush();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {

			//关闭相应的资源
			try {
				socket.shutdownInput();//关闭输入流
				if (pw!=null)
					pw.close();
				if (os!=null)
					os.close();
				if (br!=null)
					br.close();
				if (isr!=null)
					isr.close();
				if (is!=null)
					is.close();
				if (socket!=null)
					socket.close();//关闭socket
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		
	}
}
