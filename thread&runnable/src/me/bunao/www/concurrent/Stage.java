package me.bunao.www.concurrent;
/**
 * ���������Ϸ��̨
 *
 */
public class Stage extends Thread {
	@Override
	public void run() {
		super.run();
		//���ƾ���
		ArmyRunnable armyTaskOfSuiDynasty=new ArmyRunnable();
		//ũ���������
		ArmyRunnable armyTaskOfRevolt=new ArmyRunnable();
		
		//ʹ��Runnable�ӿڴ����߳�
		Thread armyOfSuiDynasty=new Thread(armyTaskOfSuiDynasty,"���");
		Thread armyOfRevolt=new Thread(armyTaskOfSuiDynasty,"ũ�������");
		//�̵߳�������  ��ʼ��ս
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		//�ô��߳̽�������      ��̨�������ߣ����������ӵ���ɱ
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println("����˫����ս��������·ɱ����һ����ҧ��");
		
		Thread mrCheng=new KeyPersonThread();
		mrCheng.setName("��ҧ��");
		System.out.println("��ҧ���������ǽ���ս����ʹ���հ�����ҵ��");
		//ֹͣ���ӵ���ս
		//ֹͣ�̵߳ķ���
		armyTaskOfRevolt.keepRunning=false;
		armyTaskOfSuiDynasty.keepRunning=false;
		
		/*
		 * ��̨�߳�ֹͣ���ó�ҧ�����
		 */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		mrCheng.start();
		try {
			//join������ʹ�����̵߳ȴ�ʹ��join�������߳̽���
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println("ս���������񰲾���ҵ��������ʵ���˻�������������");
/*		try {
			armyOfRevolt.join();
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}*/
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		new Stage().start();
	}

}
