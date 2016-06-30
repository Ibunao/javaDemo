package dididache;
import java.util.*;

public class Dididache {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//用了多态   可以将子类型放在一个父类的数组中
		Car[] car={new Aodicar("奥迪",500,4),new Pika("皮卡",700,4,3) };
		//Aodicar car1=new Aodicar("奥迪",500,4);
		//System.out.println(car1.money);用多态是无法调用子类属性值的，声明的类只能调用自身的属性值;可以在父类中添加get方法得到属性值，然后在子类中重写get方法
		//System.out.println(car[1].getMoney());
		System.out.println("欢迎使用滴滴打车系统\r\n您是否要租车：1是2否");
		Scanner input=new Scanner(System.in);
		int in=input.nextInt();
		if(in==1){
			System.out.println("您可租车的类型及其价目表：");
			System.out.println("序号  "+"   汽车名称    "+" 租金"+"	             容量");
			int i=1;
			for(Car ding:car){//遍历数组
				
				System.out.println(i+"    "+ding.out()); 
				i++;
			}
			System.out.println("请输入你要租汽车的数量：");
//			System.out.println(in);
			int num=input.nextInt();
			int sum=0;
			for(int d=0;d<num;d++){
				System.out.println("请输入第"+(d+1)+"辆车的序号：");
				int j=input.nextInt();
				sum+=car[j-1].getMoney();
				
			}
			System.out.println("请输入使用天数：");
			int days=input.nextInt();
			input.close();
			
			System.out.println("你共需要付"+sum*days+"元钱");
			
			
		}
		//Car aodi=new Aodicar("奥迪",500,4);
		//Car pika=new Pika("皮卡",500,4,3);
	}

}
