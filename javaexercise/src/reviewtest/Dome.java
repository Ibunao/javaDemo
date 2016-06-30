package reviewtest;

import java.util.Scanner;

/*
 * 功能：为指定的成绩加分，直到分数大于等于60为止
 * 输出加分前的成绩和加分后的成绩，并且统计加分的次数
 * 步骤：
 * 1.定义一个变量，用来统计加分的次数
 * 2.使用循环为成绩加分
 * 3.每次执行循环时加1分，并且统计加分的次数
 * 
 * 使用Scanner工具类来获取用户输入的值
 * Scanner类位于java.util包中，使用时需要导入此包
 * 步骤：
 * 1.导入java.util.Scanner
 * 2.创建Scanner对象
 * 3.接收并保存用户输入的值
 */

public class Dome {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner input=new Scanner(System.in);
		System.out.println("请输入你的成绩");
		int score=input.nextInt();
		int count = 0;
		while (score<60) {
			score++;
			count++;
			
		}
		System.out.println("共加了"+count+"次");
	}

}
