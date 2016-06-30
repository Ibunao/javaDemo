package tongbuyuhuchi;
/*
 * wait和notifyAll方法都是锁的方法使用wait方法会将携带的线程放进waitset集合中等待，日用notify 方法则会释放等待
 * 用法是获得锁进入到执行体内的，如果不满足条件让其wait 省得一直来竞争占用资源
 * 
 * 而sleep方法属于Thread的如果获得锁进入执行体内sleep其他线程只能等待，因为它不会释放锁
 */

public class EnergySystemTest {

	//将要构建的能量世界中能量盒子数量
	public static final int BOX_AMOUNT = 100;
	//每个盒子初始能量
    public static final double INITIAL_ENERGY = 1000;

    public static void main(String[] args){
    	EnergySystem eng = new EnergySystem(BOX_AMOUNT, INITIAL_ENERGY);
    	for (int i = 0; i < BOX_AMOUNT; i++){
    		EnergyTransferTask task = new EnergyTransferTask(eng, i, INITIAL_ENERGY);
    		Thread t = new Thread(task,"TransferThread_"+i);
    		t.start();
    	}
    }

}
