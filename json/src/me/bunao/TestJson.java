package me.bunao;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class TestJson {

	public static void main(String[] args) {
		//生成json
		Result result=new Result();
		result.setResult(1);
		List<Person>list=new ArrayList<Person>();
		result.setPersonData(list);
		Person person1=new Person();
		person1.setName("nate");
		person1.setAge(12);
		List<SchoolInfo>schools=new ArrayList<SchoolInfo>();
		SchoolInfo schoolInfo1=new SchoolInfo();
		schoolInfo1.setSchool_name("清华");
		SchoolInfo schoolInfo2=new SchoolInfo();
		schoolInfo2.setSchool_name("中工");
		schools.add(schoolInfo1);
		schools.add(schoolInfo2);
		person1.setSchool_info(schools);
		person1.setUrl("http://www.wzfzl.cn/uploads/allimg/130918/1_130918035002_4.jpg");
		list.add(person1);
		
		//转换为json
		Gson gson=new Gson();
		System.out.println(gson.toJson(result));
//		person1.setUrl("http://img.qqbody.com/uploads/allimg/201309/03-170013_301.jpg");
	}

}
