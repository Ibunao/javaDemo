package dididache;

public class Aodicar extends Car {
//	public String name;
//
//	public int money;
//	public int people;
	public Aodicar(String na,int mon,int peop){
		name=na;
		money=mon;
		people=peop;

	}
	public String out(){
		String out=name+"         "+money+"Ԫ/��"+"         "+people+"��";
		return out;
	}
//	public int getMoney() {
//		return money;
//	}
//	public void setMoney(int money) {
//		this.money = money;
//	}
}
