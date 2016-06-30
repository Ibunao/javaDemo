package source;

import static org.junit.Assert.*;

import org.junit.Test;

import source.Calculator;

public class Junit4Test1 {
//创建好后的实例
//	@Test
//	public void test() {
//		fail("尚未实现");
//	}
	
	//测试Calculator的加法
	@Test
	public void testAdd(){
		//用来测试自己的预想结果和测试结果的不同，预想值不对将发生错误
		assertEquals(6, new Calculator().add(3, 3));
	}
}
