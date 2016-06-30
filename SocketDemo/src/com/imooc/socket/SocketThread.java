package com.imooc.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.imooc.entity.File;
import com.imooc.entity.Users;
import com.imooc.service.FileService;
import com.imooc.service.UsersService;
import com.imooc.util.CommendTranser;

public class SocketThread  extends Thread{

	private Socket socket=null;
	private ObjectInputStream ois =null;//�����������������л�
    private ObjectOutputStream oos=null;//��������������л�
    private UsersService us=new UsersService();//�û�ҵ�����
    private FileService fs=new FileService();//�ļ�ҵ�����
    //ͨ�����췽��,��ʼ��socket
	public SocketThread (Socket socket){
		this.socket=socket;
	}
	@Override
	public void run() {
        try {
        	//��ȡ�ͻ��˵���Ϣ�������л�
			ois=new ObjectInputStream(socket.getInputStream());
			CommendTranser transer=(CommendTranser)ois.readObject();
			transer=execute(transer);
			
			//��ȡ����������л�����
			oos=new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(transer);
		     
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
         public CommendTranser execute(CommendTranser transer){
        	 String cmd =transer.getCmd();
        	 if(cmd.equals("login")){
        		 Users users=(Users)transer.getData();
        		 boolean flag=us.Denglu(users);
                   transer.setFlag(flag);
                   if(flag){
                	   transer.setResult("��¼�ɹ�");
                   }else{
                	   transer.setResult("�û��������벻��ȷ");
                   }
        	 }else if(cmd.equals("zhuce")){
        		 Users users=(Users)transer.getData();
        		 us.zhuce(users);
                 boolean flag= us.Denglu(users);
        	     transer.setFlag(flag);
        	     if(flag){
        	    	 transer.setResult("ע��ɹ�");
        	     }else{
        	    	 transer.setResult("ע��ʧ�ܣ�δ֪ԭ��");
        	     
        	     }	 
        	     }else if(cmd.equals("uploadFile")){
        	     File file=(File)transer.getData();
        	     fs.savefile(file);
                 transer.setResult(" �ϴ��ɹ�");   	     
        	     }
        	 return transer;
         }
         
}

