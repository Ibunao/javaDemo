package reviewtest;

public class Dome1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[][] array={{1,2,3},{4,5,6},{7,8,9}};
		int[][] array1=new int[3][];
		array1[0]=new int[4];
		array1[1]=new int[2];
		array1[2]=new int[3];
		array1[0][3]=4;
		array1[1][1]=2;
		array1[2][2]=3;
		for (int[] is : array) {
			for (int i : is) {
				System.out.println(i);
			}
		}
		for (int[] x : array1) {
			for (int y : x) {
				System.out.println(y);
			}
		}
	}

}
