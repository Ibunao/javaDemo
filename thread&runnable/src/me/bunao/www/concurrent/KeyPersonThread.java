package me.bunao.www.concurrent;

public class KeyPersonThread extends Thread {
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		super.run();
		System.out.println(getName()+"��ʼ��ս����");
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"��ͻ��ɱ���������");
		}
		System.out.println(Thread.currentThread().getName()+"��ɱ����");
	}
}
