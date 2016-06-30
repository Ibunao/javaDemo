package reviewtest;

public class Dome4 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		fff();
	}
	public static int fff(){
		for (int i = 0; i < 10; i++) {
			if (i==5) {
				//return已弹出就将结束，类似于break
				return i;
			}
			System.out.println(i);
		}
		return -1;
	}

}
