package trycatch;

public class ChainText {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		ChainText ct=new ChainText();
		ct.text2();
	}
	public void text1() throws Drinkmore{
		throw new Drinkmore("�ȶ��˱𿪳�");
	}
	public void text2(){
		try{
			text1();
		}catch(Exception e){
//			RuntimeException newExc = 
//					new RuntimeException(e);
//					new RuntimeException("˾��һ�ξƣ�����������");
//				newExc.initCause(e);//����
//				throw newExc;
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
