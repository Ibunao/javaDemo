package reviewtest;

public class Dome4 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		fff();
	}
	public static int fff(){
		for (int i = 0; i < 10; i++) {
			if (i==5) {
				//return�ѵ����ͽ�������������break
				return i;
			}
			System.out.println(i);
		}
		return -1;
	}

}
