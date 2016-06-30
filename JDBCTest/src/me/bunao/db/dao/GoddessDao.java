package me.bunao.db.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.bunao.db.db.DBUtil;
import me.bunao.db.model.Goddess;

//模型层
//实现增删改查
public class GoddessDao {
	// 添加记录
	public void addGoddess(Goddess g) {
		/*
		 * 通过获取Goddess的对象来获取所有的值
		 * 通过conn.prepareStatement(sql);方法来预处理sql语句，语句中的？号为
		 * 占位符，可以后期ptmt.setString(1, g.getUser_name());的方式给赋值
		 * 1为第一个？号，setString代表设置的是String类型的 最后通过execute方法执行
		 */
		// 获取连接
		Connection conn = DBUtil.getConnection();
		// 定义sql语句
		try {
			String sql = "" + "INSERT INTO goddess" + "(user_name,sex,age,birthday,email,mobile,create_user,"
					+ "create_date,update_user,update_date,isdel)" + "VALUES("
					+ "?,?,?,?,?,?,?,current_date(),?,current_date(),?)";// current_date()是mysql的时间函数
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, g.getUser_name());
			ptmt.setBoolean(2, g.getSex());
			ptmt.setShort(3, g.getAge());
			// 将java.util的date类型转为java.sql类型  java.sql.Date是java.util.Date的子集
			ptmt.setDate(4, new Date(g.getBirthday().getTime()));
			ptmt.setString(5, g.getEmail());
			ptmt.setString(6, g.getMobile());
			ptmt.setString(7, g.getCreate_user());
			ptmt.setString(8, g.getUpdate_user());
			ptmt.setBoolean(9, g.getIsdel());

			// 执行
			ptmt.execute();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	// 更新记录
	public void updateGoddess(Goddess g) {
		// 获取连接
		Connection conn = DBUtil.getConnection();
		// 定义sql语句 加空格，因为执行的时候会合并成一行
		try {
			String sql = "" + " UPDATE  goddess" + " SET user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,"
					+ "update_user=?,update_date=current_date(),isdel=? " + " WHERE id=? ";// current_date()是mysql的时间函数
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, g.getUser_name());
			ptmt.setBoolean(2, g.getSex());
			ptmt.setShort(3, g.getAge());
			// 将java.util的date类型转为java.sql类型
			ptmt.setDate(4, new Date(g.getBirthday().getTime()));
			ptmt.setString(5, g.getEmail());
			ptmt.setString(6, g.getMobile());
			ptmt.setString(7, g.getUpdate_user());
			ptmt.setBoolean(8, g.getIsdel());
			ptmt.setInt(9, g.getId());

			// 执行
			ptmt.execute();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	// 删除记录
	public void delGoddess(Integer id) {
		// 获取连接
		Connection conn = DBUtil.getConnection();
		// 定义sql语句 加空格，因为执行的时候会合并成一行
		try {
			String sql = "" + " DELETE FROM  goddess" + " WHERE id=? ";// current_date()是mysql的时间函数
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			// 执行
			ptmt.execute();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	// 查询所有的数据
	public List<Goddess> query(){
		Connection conn = DBUtil.getConnection();
		String sql=""+" SELECT * FROM goddess";
		List<Goddess> gs = new ArrayList<Goddess>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			Goddess g = null;
			// 循环读取获取到的数据
			while (result.next()) {
				g = new Goddess();
				// 设置对象的属性值
				g.setId(result.getShort("id"));
				g.setUser_name(result.getString("user_name"));
				g.setAge(result.getShort("age"));
				g.setSex(result.getBoolean("sex"));
				g.setBirthday(result.getDate("birthday"));
				g.setEmail(result.getString("email"));
				g.setMobile(result.getString("mobile"));
				g.setCreate_user(result.getString("create_user"));
				g.setCreate_date(result.getDate("create_user"));
				g.setUpdate_user(result.getString("update_user"));
				g.setUpdate_date(result.getDate("Update_user"));
				g.setIsdel(result.getBoolean("isdel"));
				// 添加到list集合中
				gs.add(g);
				// System.out.println("姓名："+result.getString("user_name")+"年龄："+result.getString("age"));
			}
			return gs;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
		
	}
	//添加参数，通过传入的某个参数  查询记录
	public List<Goddess> query(List<Map<String,Object>>params) throws SQLException {
		// 获取连接
		Connection conn = DBUtil.getConnection();
		/*Statement stmt = conn.createStatement();
		// 获取查询到的数据 ResultSet加载的是java中的包
		ResultSet rs = stmt.executeQuery("SELECT user_name,age FROM goddess");*/

		StringBuilder sb=new StringBuilder();
		//添加1+1 是为了让后面的and可以很好的连接   如果  params=null  则筛选出所有的    在开发中经常用到
		sb.append("SELECT * FROM goddess WHERE 1=1 ");
		if (params!=null&&params.size()>0) {
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map=params.get(i);
				//分别获取 属性名    符号    值
				sb.append(" AND "+map.get("name")+" "+map.get("rela")+ " " +map.get("value"));
			}
		}
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		System.out.println(sb.toString());
		ResultSet rs = ptmt.executeQuery();
		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess g = null;
		// 循环读取获取到的数据
		while (rs.next()) {
			g = new Goddess();
			// 设置对象的属性值
			g.setId(rs.getShort("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getShort("age"));
			g.setSex(rs.getBoolean("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_user(rs.getString("create_user"));
			g.setCreate_date(rs.getDate("create_user"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setUpdate_date(rs.getDate("Update_user"));
			g.setIsdel(rs.getBoolean("isdel"));
			// 添加到list集合中
			gs.add(g);
			// System.out.println("姓名："+rs.getString("user_name")+"年龄："+rs.getString("age"));
		}
		return gs;

	}

	// 查询单条数据
	public Goddess getQuery(Integer id) {
		Goddess g=null;
		// 获取连接
		Connection conn = DBUtil.getConnection();
		// 定义sql语句 加空格，因为执行的时候会合并成一行
		try {
			String sql = "" + " SELECT * FROM goddess" + " WHERE id=? ";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1,id);

			// 执行查询要用executeQuery，且返回一个结果集
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				g=new Goddess();
				g.setId(rs.getShort("id"));
				g.setUser_name(rs.getString("user_name"));
				g.setAge(rs.getShort("age"));
				g.setSex(rs.getBoolean("sex"));
				g.setBirthday(rs.getDate("birthday"));
				g.setEmail(rs.getString("email"));
				g.setMobile(rs.getString("mobile"));
				g.setCreate_user(rs.getString("create_user"));
				g.setCreate_date(rs.getDate("create_user"));
				g.setUpdate_user(rs.getString("update_user"));
				g.setUpdate_date(rs.getDate("Update_user"));
				g.setIsdel(rs.getBoolean("isdel"));
			}
			return g;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

}
