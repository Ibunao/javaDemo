package me.bunao.db.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Ҳ�������ݿ��
 * �������ݿ�
 */
public class DBUtil {
	//jdbc:mysql: �����ʾ���ӵ���mysql���ݿ�  //127.0.0.1 IP��ַ   :3306 �˿�  /imooc  ���ݿ����
	private static final String URL="jdbc:mysql://127.0.0.1:3306/jdbc";
	private static final String USER="root";
	private static final String PASSWORD="159753";
	
	private static Connection conn=null;
	//��̬�죬ִ�е������
	static{
		try {
			//1.������������      ʹ�÷���
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ���ݿ������
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	//���ⲿ��ȡConnection
	public static Connection getConnection(){
		return conn;
	}
	public static void main(String[] args)  {
		
		try {
			/*//1.������������      ʹ�÷���
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ���ݿ������
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);*/
			//3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ�
			Statement stmt = conn.createStatement();
			//��ȡ��ѯ��������    ResultSet���ص���java�еİ�
			ResultSet rs = stmt.executeQuery("SELECT user_name,age FROM goddess");
			
			//ѭ����ȡ��ȡ��������
			while (rs.next()) {
				System.out.println("������"+rs.getString("user_name")+"���䣺"+rs.getString("age"));
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}

}
