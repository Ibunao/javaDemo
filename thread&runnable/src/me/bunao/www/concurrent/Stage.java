package me.bunao.www.concurrent;
/**
 * 隋唐演义大戏舞台
 *
 */
public class Stage extends Thread {
	@Override
	public void run() {
		super.run();
		//随唐军队
		ArmyRunnable armyTaskOfSuiDynasty=new ArmyRunnable();
		//农民起义军队
		ArmyRunnable armyTaskOfRevolt=new ArmyRunnable();
		
		//使用Runnable接口创建线程
		Thread armyOfSuiDynasty=new Thread(armyTaskOfSuiDynasty,"隋军");
		Thread armyOfRevolt=new Thread(armyTaskOfSuiDynasty,"农民起义军");
		//线程的启动，  开始作战
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		//让此线程进行休眠      舞台进行休眠，看两个军队的厮杀
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("正当双方激战正酣，半路杀出了一个程咬金");
		
		Thread mrCheng=new KeyPersonThread();
		mrCheng.setName("程咬金");
		System.out.println("程咬金的理想就是结束战争，使百姓安居乐业！");
		//停止军队的作战
		//停止线程的方法
		armyTaskOfRevolt.keepRunning=false;
		armyTaskOfSuiDynasty.keepRunning=false;
		
		/*
		 * 舞台线程停止，让程咬金出场
		 */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		mrCheng.start();
		try {
			//join方法会使所有线程等待使用join方法的线程结束
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("战争结束人民安居乐业，程先生实现了积极的人生梦想");
/*		try {
			armyOfRevolt.join();
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}*/
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new Stage().start();
	}

}
