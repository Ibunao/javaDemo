package me.bunao.db.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.bunao.db.dao.GoddessDao;
import me.bunao.db.model.Goddess;
//控制层
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
		// TODO 自动生成的方法存根
		GoddessDao g=new GoddessDao();
		//测试查询
		List<Goddess> gs = g.query();
		for (Goddess goddess : gs) {
			System.out.println("姓名："+goddess.getUser_name() +"年龄："+goddess.getAge());
		}
		//测试修改后的用name查询单条记录
		List<Map<String,Object>> params=new ArrayList<Map<String,Object>>();
		Map<String, Object> param=new HashMap<String, Object>();
		param.put("name", "user_name");
		param.put("rela", "=");
		//因为字符串的 要映射到sql语句，所以加上单引号
		param.put("value", "'小美'");
		params.add(param);
		List<Goddess> gs = g.query(params);
		for (Goddess goddess : gs) {
			System.out.println(goddess.toString());
		}
		//测试添加
		Goddess g1=new Goddess();
		g1.setUser_name("小夏");
		g1.setAge((short) 23);
		g1.setSex(true);
		g1.setBirthday(new Date());
		g1.setEmail("idingran@163.com");
		g1.setMobile("159753456");
		g1.setCreate_user("BUNAO");
		g1.setUpdate_user("bunao");
		g1.setIsdel(true);
		g.addGoddess(g1);
		
		//测试更新
		g1.setId((short) 3);
		g1.setUser_name("小夏");
		g1.setAge((short) 20);
		g1.setSex(true);
		g1.setBirthday(new Date());
		g1.setEmail("bunao@163.com");
		g1.setMobile("1591564856");
		//不用更新创建人
		g1.setUpdate_user("BUNAO");
		g1.setIsdel(true);
		g.updateGoddess(g1);
		
		//测试删除
		g.delGoddess(3);
		
		//测试通过id获取单条记录
		Goddess res = g.getQuery(2);
		System.out.println(g1.toString());
		
	}*/

}
