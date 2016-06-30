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
		// TODO �Զ����ɵĹ��캯�����
		this.socket=sc;
	}
	@Override
	public void run() {
//		// TODO �Զ����ɵķ������
//		super.run();
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			//��ȡ�ֽ�������������ȡ�ͻ�����Ϣ
			is = socket.getInputStream();
			//���ֽ���ת��Ϊ�ַ���
			isr=new InputStreamReader(is);
			//��ӻ���
			br=new BufferedReader(isr);
			//ѭ����ȡ�ͻ��˵���Ϣ
			String info=null;
			while ((info=br.readLine())!=null) {
				System.out.println("���Ƿ��������ͻ���˵��"+info);
			}
			//��ȡ���������Ӧ�ͻ��˵����󣬺Ϳͻ��˵ķ�����Ϣ����
			os = socket.getOutputStream();
			//��װ�ɴ�ӡ��
			pw = new PrintWriter(os);
			//��Ӧ�ͻ��˵�����
			pw.write("��ӭ����");
			//ˢ�»���    Ҫ����
			pw.flush();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {

			//�ر���Ӧ����Դ
			try {
				socket.shutdownInput();//�ر�������
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
					socket.close();//�ر�socket
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
		
	}
}
