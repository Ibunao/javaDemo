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

//ģ�Ͳ�
//ʵ����ɾ�Ĳ�
public class GoddessDao {
	// ��Ӽ�¼
	public void addGoddess(Goddess g) {
		/*
		 * ͨ����ȡGoddess�Ķ�������ȡ���е�ֵ
		 * ͨ��conn.prepareStatement(sql);������Ԥ����sql��䣬����еģ���Ϊ
		 * ռλ�������Ժ���ptmt.setString(1, g.getUser_name());�ķ�ʽ����ֵ
		 * 1Ϊ��һ�����ţ�setString�������õ���String���͵� ���ͨ��execute����ִ��
		 */
		// ��ȡ����
		Connection conn = DBUtil.getConnection();
		// ����sql���
		try {
			String sql = "" + "INSERT INTO goddess" + "(user_name,sex,age,birthday,email,mobile,create_user,"
					+ "create_date,update_user,update_date,isdel)" + "VALUES("
					+ "?,?,?,?,?,?,?,current_date(),?,current_date(),?)";// current_date()��mysql��ʱ�亯��
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, g.getUser_name());
			ptmt.setBoolean(2, g.getSex());
			ptmt.setShort(3, g.getAge());
			// ��java.util��date����תΪjava.sql����  java.sql.Date��java.util.Date���Ӽ�
			ptmt.setDate(4, new Date(g.getBirthday().getTime()));
			ptmt.setString(5, g.getEmail());
			ptmt.setString(6, g.getMobile());
			ptmt.setString(7, g.getCreate_user());
			ptmt.setString(8, g.getUpdate_user());
			ptmt.setBoolean(9, g.getIsdel());

			// ִ��
			ptmt.execute();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}

	// ���¼�¼
	public void updateGoddess(Goddess g) {
		// ��ȡ����
		Connection conn = DBUtil.getConnection();
		// ����sql��� �ӿո���Ϊִ�е�ʱ���ϲ���һ��
		try {
			String sql = "" + " UPDATE  goddess" + " SET user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,"
					+ "update_user=?,update_date=current_date(),isdel=? " + " WHERE id=? ";// current_date()��mysql��ʱ�亯��
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, g.getUser_name());
			ptmt.setBoolean(2, g.getSex());
			ptmt.setShort(3, g.getAge());
			// ��java.util��date����תΪjava.sql����
			ptmt.setDate(4, new Date(g.getBirthday().getTime()));
			ptmt.setString(5, g.getEmail());
			ptmt.setString(6, g.getMobile());
			ptmt.setString(7, g.getUpdate_user());
			ptmt.setBoolean(8, g.getIsdel());
			ptmt.setInt(9, g.getId());

			// ִ��
			ptmt.execute();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	// ɾ����¼
	public void delGoddess(Integer id) {
		// ��ȡ����
		Connection conn = DBUtil.getConnection();
		// ����sql��� �ӿո���Ϊִ�е�ʱ���ϲ���һ��
		try {
			String sql = "" + " DELETE FROM  goddess" + " WHERE id=? ";// current_date()��mysql��ʱ�亯��
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			// ִ��
			ptmt.execute();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	// ��ѯ���е�����
	public List<Goddess> query(){
		Connection conn = DBUtil.getConnection();
		String sql=""+" SELECT * FROM goddess";
		List<Goddess> gs = new ArrayList<Goddess>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			Goddess g = null;
			// ѭ����ȡ��ȡ��������
			while (result.next()) {
				g = new Goddess();
				// ���ö��������ֵ
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
				// ��ӵ�list������
				gs.add(g);
				// System.out.println("������"+result.getString("user_name")+"���䣺"+result.getString("age"));
			}
			return gs;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
		
	}
	//��Ӳ�����ͨ�������ĳ������  ��ѯ��¼
	public List<Goddess> query(List<Map<String,Object>>params) throws SQLException {
		// ��ȡ����
		Connection conn = DBUtil.getConnection();
		/*Statement stmt = conn.createStatement();
		// ��ȡ��ѯ�������� ResultSet���ص���java�еİ�
		ResultSet rs = stmt.executeQuery("SELECT user_name,age FROM goddess");*/

		StringBuilder sb=new StringBuilder();
		//���1+1 ��Ϊ���ú����and���Ժܺõ�����   ���  params=null  ��ɸѡ�����е�    �ڿ����о����õ�
		sb.append("SELECT * FROM goddess WHERE 1=1 ");
		if (params!=null&&params.size()>0) {
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map=params.get(i);
				//�ֱ��ȡ ������    ����    ֵ
				sb.append(" AND "+map.get("name")+" "+map.get("rela")+ " " +map.get("value"));
			}
		}
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		System.out.println(sb.toString());
		ResultSet rs = ptmt.executeQuery();
		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess g = null;
		// ѭ����ȡ��ȡ��������
		while (rs.next()) {
			g = new Goddess();
			// ���ö��������ֵ
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
			// ��ӵ�list������
			gs.add(g);
			// System.out.println("������"+rs.getString("user_name")+"���䣺"+rs.getString("age"));
		}
		return gs;

	}

	// ��ѯ��������
	public Goddess getQuery(Integer id) {
		Goddess g=null;
		// ��ȡ����
		Connection conn = DBUtil.getConnection();
		// ����sql��� �ӿո���Ϊִ�е�ʱ���ϲ���һ��
		try {
			String sql = "" + " SELECT * FROM goddess" + " WHERE id=? ";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1,id);

			// ִ�в�ѯҪ��executeQuery���ҷ���һ�������
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}

}
