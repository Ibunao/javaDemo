package me.bunao.db.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 连接数据库
 */
public class DBUtilTest {
	//jdbc:mysql: 这个表示连接的是mysql数据库  //127.0.0.1 IP地址   :3306 端口  /imooc  数据库库名
	private static final String URL="jdbc:mysql://127.0.0.1:3306/jdbc";
	private static final String USER="root";
	private static final String PASSWORD="159753";
	public static void main(String[] args)  {
		//1.加载驱动程序      使用反射
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取数据库的连接
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			//3.通过数据库的连接操作数据库，实现增删改查
			Statement stmt = conn.createStatement();
			//获取查询到的数据    ResultSet加载的是java中的包
			ResultSet rs = stmt.executeQuery("SELECT user_name,age FROM goddess");
			
			//循环读取获取到的数据
			while (rs.next()) {
				System.out.println("姓名："+rs.getString("user_name")+"年龄："+rs.getString("age"));
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
