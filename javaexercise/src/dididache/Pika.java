package dididache;

public class Pika extends Car {
//	public String name;
//	public int money;
//	public int people;
//	public int carry;
	public Pika(String name,int money,int people,int carry){
		this.name=name;//Ϊʲô����Ҫ��this����Ϊ��Ա�����ʹ��εı���һ�����ʹ��α�����һ���ǾͲ���this����Aodicar
		this.money=money;
		this.people=people;
		this.carry=carry;
		
		
	}
	public String out(){
		String out=name+"         "+money+"Ԫ/��"+"         "+people+"��"+carry+"��";
		return out;
	}
//	public int getMoney() {
//		return money;
//	}
//	public void setMoney(int money) {
//		this.money = money;
//	}
}
