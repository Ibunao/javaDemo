package me.bunao.www.concurrent;
//军队线程
//模拟作战双方的行为
public class ArmyRunnable implements Runnable {
	//volatile保证了线程可以正确的读取其他进程写入的值
	//可见性 ref JMM,happens-before原则
	//运用退出旗标来保证线程的顺利退出
	volatile boolean keepRunning=true;

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while (keepRunning) {
			//发动五连击
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]次");
				//让出了处理器时间，下次该谁进攻还不一定呢！
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName()+"进攻结束");
	}

}
