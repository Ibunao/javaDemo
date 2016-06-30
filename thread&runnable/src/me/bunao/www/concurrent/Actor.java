package me.bunao.www.concurrent;

public class Actor extends Thread {
	public void run() {
		// ��ȡ�̵߳ķ���
		System.out.println(getName() + "��һ����Ա��");
		int count = 0;
		boolean keepRunning = true;
		while (keepRunning) {
			System.out.println(getName() + "��̨�ݳ���" + (++count));
			if (count == 100) {
				keepRunning = false;
			}
			if (count % 10 == 0) {
				// ��Ϣ
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
		System.out.println(getName() + "�ݳ�������");
	}

	public static void main(String[] args) {
		Thread actor = new Actor();
		// �����߳�����
		actor.setName("Mr.Thread");
		// ��ʼ�߳�
		actor.start();
		//����ʵ�����߳̽ӿ�Runnable���̶߳���������������
		Thread actressThread=new Thread(new Actress(), "MS.Runnable");
		actressThread.start();
	}
}

class Actress implements Runnable {

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		// ��ȡ��ǰ�̵߳ķ���
		System.out.println(Thread.currentThread().getName() + "��һ����Ա��");
		int count = 0;
		boolean keepRunning = true;
		while (keepRunning) {
			System.out.println(Thread.currentThread().getName() + "��̨�ݳ���" + (++count));
			if (count == 100) {
				keepRunning = false;
			}
			if (count % 10 == 0) {
				// ��Ϣ
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + "�ݳ�������");
	}

}
