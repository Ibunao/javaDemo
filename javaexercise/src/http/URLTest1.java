package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * ��ȡ������Դ
 */
public class URLTest1 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		try {
			//�����http
			URL url=new URL("http://ibunao.github.io/bunao/");
//			URL url=new URL("http://www.bunao.me/");
			//�����ֽ���
			InputStream input = url.openStream();
			//ת��Ϊ�ַ���
			 InputStreamReader isr = new InputStreamReader(input,"utf-8");
			 //ʹ�û������Ӷ�ȡЧ��
			 BufferedReader buf=new BufferedReader(isr);
			 //��ȡһ��
			 String data = buf.readLine();
			 while (data!=null) {
				System.out.println(data);
				//��ȡ��һ��
				data=buf.readLine();
				
			}
			 //�ر���
			 buf.close();
			 isr.close();
			 input.close();
		} catch (MalformedURLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}