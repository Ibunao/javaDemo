package me.bunao.db.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.bunao.db.action.GoddessAction;
import me.bunao.db.model.Goddess;

public class TestAction {
	//���Կ��Ʋ�
	public static void main(String[] args) throws SQLException {
		GoddessAction action=new GoddessAction();
		/*//���Բ�ѯ
		List<Goddess>result=action.query();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId()+" "+result.get(i).getUser_name());
			
		}*/
		
		//�������
		Goddess g=new Goddess();
		g.setUser_name("С��");
		g.setSex(true);
		g.setAge((short) 23);
		g.setBirthday(new Date());
		g.setEmail("ibunao@163.com");
		g.setMobile("1562222222");
		g.setIsdel(false);
		//���
//		action.add(g);
		//��������   ��Ҫid
//		g.setId((short) 5);
//		action.edit(g);
//		//ɾ��
//		action.del(5);
		//ͨ��ĳ���ֶβ�ѯ
		List<Map<String, Object>>params=new ArrayList<Map<String, Object>>();
		Map<String, Object>map=new HashMap<String, Object>();
		//ͨ��user_name�ֶ�����ѯ
		map.put("name", "user_name");
		map.put("rela", "=");
		//���ӵ����Ż�����
		map.put("value", "'С��'");
		params.add(map);
		List<Goddess>result=action.query(params);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId()+" "+result.get(i).getUser_name());
			
		}
	}

}
