package http;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * URL���÷���
 * 
 */
public class URLTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		try {
			//����һ��URLʵ��
			URL bunao=new URL("http://www.bunao.me");
			//ͨ�����е�URLʵ������һ���µ�URL
			//�������ʾ������#�����ʾê��
			URL url=new URL(bunao, "/index.html?urername=tom#test");
			System.out.println("Э��:"+url.getProtocol());
			System.out.println("����:"+url.getHost());
			//���δָ���˿ںţ���ʹ��Ĭ�ϵĶ˿ںţ���ʱgetPort()��������ֵΪ-1
			System.out.println("�˿�:"+url.getPort());
			System.out.println("�ļ�·��:"+url.getPath());
			System.out.println("�ļ���:"+url.getFile());
			//#�����ê��
			System.out.println("���·��:"+url.getRef());
			//������Ĳ���
			System.out.println("��ѯ�ַ���:"+url.getQuery());
		} catch (MalformedURLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
