package string;

public class Stringtest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String s1 = "imooc";
		String s2 = "imooc";
        
        //�����ַ���s3�����桰I love����s1ƴ�Ӻ������        
        String s3=new String("imooc");
        String s4=new String("imooc");
		
        // �Ƚ��ַ���s1��s2
		// imoocΪ�����ַ�������γ���ʱ�ᱻ�������Ż���ֻ����һ������
		System.out.println("s1��s2�ڴ��ַ��ͬ��" + (s1 == s2));
        
        //�Ƚ��ַ���s1��s3
		System.out.println("s1��s3�ڴ��ַ��ͬ��" +      (s1==s3)   );
		System.out.println("s1��s3ֵ��ͬ��" +      s1.equals(s3)   );
		System.out.println("s1��s3�ڴ��ַ��ͬ��" +      (s4==s3)   );
		System.out.println("s1��s3ֵ��ͬ��" +      s4.equals(s3)   );
		
		// ����һ���ַ���
		String s = "aljlkdsflkjsadjfklhasdkjlflkajdflwoiudsafhaasdasd";
        
        // ���ִ���
		int num = 0;
        
         // ѭ������ÿ���ַ����ж��Ƿ����ַ� a ������ǣ��ۼӴ���
		for (int i=0;i<s.length();i++)
		{
            // ��ȡÿ���ַ����ж��Ƿ����ַ�a
			if ( s.charAt(i)=='a') {
                // �ۼ�ͳ�ƴ���
				num++; 
			}
		}
		System.out.println("�ַ�a���ֵĴ�����" + num);
		
		
		
		
	    // ����һ���������飬����Ϊ10
			int[] nums = new int[10];
	        
	        //ͨ��ѭ�������鸳ֵ
			for (int i = 0; i < nums.length; i++) {
	            // ����10���ڵ������
				int x = (int) (Math.random()*10);
	            
				nums[i] = x;// ΪԪ�ظ�ֵ
			}
	        
			// ʹ��foreachѭ����������е�Ԫ��
			for (   int i=0;i<nums.length;i++                 ) {         int num1=nums[i];
				System.out.print(num1 + " ");
				
			}
			
			
		System.out.println();	
		String[] ding=new String[10];
		System.out.println(ding.length);
		
		
		String ran = "a l j l k d sfl kjsa djfk lhas dkj lf lka jdfl oiud saf haasd asd";
		String[] bu=ran.split(" ");
		System.out.println(bu.length);
		System.out.println(ran.length());
	}
	

}
