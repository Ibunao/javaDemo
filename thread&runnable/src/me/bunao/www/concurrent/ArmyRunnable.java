package me.bunao.www.concurrent;
//�����߳�
//ģ����ս˫������Ϊ
public class ArmyRunnable implements Runnable {
	//volatile��֤���߳̿�����ȷ�Ķ�ȡ��������д���ֵ
	//�ɼ��� ref JMM,happens-beforeԭ��
	//�����˳��������֤�̵߳�˳���˳�
	volatile boolean keepRunning=true;

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while (keepRunning) {
			//����������
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+"�����Է�["+i+"]��");
				//�ó��˴�����ʱ�䣬�´θ�˭��������һ���أ�
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName()+"��������");
	}

}
