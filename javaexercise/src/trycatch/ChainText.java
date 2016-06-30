package trycatch;

public class ChainText {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ChainText ct=new ChainText();
		ct.text2();
	}
	public void text1() throws Drinkmore{
		throw new Drinkmore("喝多了别开车");
	}
	public void text2(){
		try{
			text1();
		}catch(Exception e){
//			RuntimeException newExc = 
//					new RuntimeException(e);
//					new RuntimeException("司机一滴酒，亲人两行泪");
//				newExc.initCause(e);//绑定链
//				throw newExc;
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
