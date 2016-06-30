package http;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * URL常用方法
 * 
 */
public class URLTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try {
			//创建一个URL实例
			URL bunao=new URL("http://www.bunao.me");
			//通过已有的URL实例创建一个新的URL
			//？后面表示参数，#后面标示锚点
			URL url=new URL(bunao, "/index.html?urername=tom#test");
			System.out.println("协议:"+url.getProtocol());
			System.out.println("主机:"+url.getHost());
			//如果未指定端口号，则使用默认的端口号，此时getPort()方法返回值为-1
			System.out.println("端口:"+url.getPort());
			System.out.println("文件路径:"+url.getPath());
			System.out.println("文件名:"+url.getFile());
			//#后面的锚点
			System.out.println("相对路径:"+url.getRef());
			//？后面的参数
			System.out.println("查询字符串:"+url.getQuery());
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
