package dididache;

public class Pika extends Car {
//	public String name;
//	public int money;
//	public int people;
//	public int carry;
	public Pika(String name,int money,int people,int carry){
		this.name=name;//为什么必须要用this，因为成员变量和传参的变量一样，和传参变量不一样是就不用this，如Aodicar
		this.money=money;
		this.people=people;
		this.carry=carry;
		
		
	}
	public String out(){
		String out=name+"         "+money+"元/天"+"         "+people+"人"+carry+"吨";
		return out;
	}
//	public int getMoney() {
//		return money;
//	}
//	public void setMoney(int money) {
//		this.money = money;
//	}
}
