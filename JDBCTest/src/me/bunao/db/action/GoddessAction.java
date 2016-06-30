package me.bunao.db.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.bunao.db.dao.GoddessDao;
import me.bunao.db.model.Goddess;
//���Ʋ�
public class GoddessAction {
	public void add(Goddess g){
		GoddessDao dao=new GoddessDao();
		dao.addGoddess(g);
	}
	public Goddess get (Integer id){
		GoddessDao dao=new GoddessDao();
		return dao.getQuery(id);
	}
	public void edit(Goddess g){
		GoddessDao dao=new GoddessDao();
		dao.updateGoddess(g);
	}
	public void del(Integer id){
		GoddessDao dao=new GoddessDao();
		dao.delGoddess(id);
	}
	public List<Goddess> query(){
		GoddessDao dao=new GoddessDao();
		return dao.query();
	}
	public List<Goddess> query(List<Map<String,Object>>params) throws SQLException{
		GoddessDao dao=new GoddessDao();
		return dao.query(params);
	}
/*	public static void main(String[] args) throws SQLException {
		// TODO �Զ����ɵķ������
		GoddessDao g=new GoddessDao();
		//���Բ�ѯ
		List<Goddess> gs = g.query();
		for (Goddess goddess : gs) {
			System.out.println("������"+goddess.getUser_name() +"���䣺"+goddess.getAge());
		}
		//�����޸ĺ����name��ѯ������¼
		List<Map<String,Object>> params=new ArrayList<Map<String,Object>>();
		Map<String, Object> param=new HashMap<String, Object>();
		param.put("name", "user_name");
		param.put("rela", "=");
		//��Ϊ�ַ����� Ҫӳ�䵽sql��䣬���Լ��ϵ�����
		param.put("value", "'С��'");
		params.add(param);
		List<Goddess> gs = g.query(params);
		for (Goddess goddess : gs) {
			System.out.println(goddess.toString());
		}
		//�������
		Goddess g1=new Goddess();
		g1.setUser_name("С��");
		g1.setAge((short) 23);
		g1.setSex(true);
		g1.setBirthday(new Date());
		g1.setEmail("idingran@163.com");
		g1.setMobile("159753456");
		g1.setCreate_user("BUNAO");
		g1.setUpdate_user("bunao");
		g1.setIsdel(true);
		g.addGoddess(g1);
		
		//���Ը���
		g1.setId((short) 3);
		g1.setUser_name("С��");
		g1.setAge((short) 20);
		g1.setSex(true);
		g1.setBirthday(new Date());
		g1.setEmail("bunao@163.com");
		g1.setMobile("1591564856");
		//���ø��´�����
		g1.setUpdate_user("BUNAO");
		g1.setIsdel(true);
		g.updateGoddess(g1);
		
		//����ɾ��
		g.delGoddess(3);
		
		//����ͨ��id��ȡ������¼
		Goddess res = g.getQuery(2);
		System.out.println(g1.toString());
		
	}*/

}
