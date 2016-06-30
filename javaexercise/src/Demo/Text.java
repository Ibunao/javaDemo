package Demo;

public class Text {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Person c=new Chinese();
		c.say();
		Person a=new American();
		a.say();
		Ding ding=new Ding(){
			public void ran(){
				System.out.println("ding");
			}
		};
		ding.ran();
	}

}
class Ding{
	public void ding(){
		System.out.println("ran");
	}

	public void ran() {
		// TODO 自动生成的方法存根
		
	}
}