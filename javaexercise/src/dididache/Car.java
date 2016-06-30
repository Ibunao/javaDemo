package dididache;

public abstract class Car {
	public String name;
	public int money;
	public int people;
	public int carry;
	public abstract String out();
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}
