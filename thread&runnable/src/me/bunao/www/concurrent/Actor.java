package me.bunao.www.concurrent;

public class Actor extends Thread {
	public void run() {
		// 获取线程的方法
		System.out.println(getName() + "是一个演员！");
		int count = 0;
		boolean keepRunning = true;
		while (keepRunning) {
			System.out.println(getName() + "登台演出：" + (++count));
			if (count == 100) {
				keepRunning = false;
			}
			if (count % 10 == 0) {
				// 休息
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		System.out.println(getName() + "演出结束！");
	}

	public static void main(String[] args) {
		Thread actor = new Actor();
		// 设置线程名称
		actor.setName("Mr.Thread");
		// 开始线程
		actor.start();
		//创建实现了线程接口Runnable的线程对象，设置她的名字
		Thread actressThread=new Thread(new Actress(), "MS.Runnable");
		actressThread.start();
	}
}

class Actress implements Runnable {

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		// 获取当前线程的方法
		System.out.println(Thread.currentThread().getName() + "是一个演员！");
		int count = 0;
		boolean keepRunning = true;
		while (keepRunning) {
			System.out.println(Thread.currentThread().getName() + "登台演出：" + (++count));
			if (count == 100) {
				keepRunning = false;
			}
			if (count % 10 == 0) {
				// 休息
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + "演出结束！");
	}

}
