package source;

import static org.junit.Assert.*;

import org.junit.Test;

import source.Calculator;

public class Junit4Test1 {
//�����ú��ʵ��
//	@Test
//	public void test() {
//		fail("��δʵ��");
//	}
	
	//����Calculator�ļӷ�
	@Test
	public void testAdd(){
		//���������Լ���Ԥ�����Ͳ��Խ���Ĳ�ͬ��Ԥ��ֵ���Խ���������
		assertEquals(6, new Calculator().add(3, 3));
	}
}
