package me.bunao.www.concurrent;

public class KeyPersonThread extends Thread {
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		super.run();
		System.out.println(getName()+"开始了战斗！");
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"左突右杀，攻击隋军");
		}
		System.out.println(Thread.currentThread().getName()+"厮杀结束");
	}
}
