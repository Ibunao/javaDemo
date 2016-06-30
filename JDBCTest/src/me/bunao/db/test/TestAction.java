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
	//测试控制层
	public static void main(String[] args) throws SQLException {
		GoddessAction action=new GoddessAction();
		/*//测试查询
		List<Goddess>result=action.query();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId()+" "+result.get(i).getUser_name());
			
		}*/
		
		//测试添加
		Goddess g=new Goddess();
		g.setUser_name("小青");
		g.setSex(true);
		g.setAge((short) 23);
		g.setBirthday(new Date());
		g.setEmail("ibunao@163.com");
		g.setMobile("1562222222");
		g.setIsdel(false);
		//添加
//		action.add(g);
		//更新数据   需要id
//		g.setId((short) 5);
//		action.edit(g);
//		//删除
//		action.del(5);
		//通过某个字段查询
		List<Map<String, Object>>params=new ArrayList<Map<String, Object>>();
		Map<String, Object>map=new HashMap<String, Object>();
		//通过user_name字段来查询
		map.put("name", "user_name");
		map.put("rela", "=");
		//不加单引号会出错的
		map.put("value", "'小美'");
		params.add(map);
		List<Goddess>result=action.query(params);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId()+" "+result.get(i).getUser_name());
			
		}
	}

}
