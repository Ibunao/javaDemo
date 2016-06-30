package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * 读取网络资源
 */
public class URLTest1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try {
			//必须加http
			URL url=new URL("http://ibunao.github.io/bunao/");
//			URL url=new URL("http://www.bunao.me/");
			//创建字节流
			InputStream input = url.openStream();
			//转换为字符流
			 InputStreamReader isr = new InputStreamReader(input,"utf-8");
			 //使用缓冲增加读取效率
			 BufferedReader buf=new BufferedReader(isr);
			 //读取一行
			 String data = buf.readLine();
			 while (data!=null) {
				System.out.println(data);
				//读取下一行
				data=buf.readLine();
				
			}
			 //关闭流
			 buf.close();
			 isr.close();
			 input.close();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
