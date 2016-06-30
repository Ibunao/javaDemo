package string;

public class Stringtest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String s1 = "imooc";
		String s2 = "imooc";
        
        //定义字符串s3，保存“I love”和s1拼接后的内容        
        String s3=new String("imooc");
        String s4=new String("imooc");
		
        // 比较字符串s1和s2
		// imooc为常量字符串，多次出现时会被编译器优化，只创建一个对象
		System.out.println("s1和s2内存地址相同吗？" + (s1 == s2));
        
        //比较字符串s1和s3
		System.out.println("s1和s3内存地址相同吗？" +      (s1==s3)   );
		System.out.println("s1和s3值相同吗？" +      s1.equals(s3)   );
		System.out.println("s1和s3内存地址相同吗？" +      (s4==s3)   );
		System.out.println("s1和s3值相同吗？" +      s4.equals(s3)   );
		
		// 定义一个字符串
		String s = "aljlkdsflkjsadjfklhasdkjlflkajdflwoiudsafhaasdasd";
        
        // 出现次数
		int num = 0;
        
         // 循环遍历每个字符，判断是否是字符 a ，如果是，累加次数
		for (int i=0;i<s.length();i++)
		{
            // 获取每个字符，判断是否是字符a
			if ( s.charAt(i)=='a') {
                // 累加统计次数
				num++; 
			}
		}
		System.out.println("字符a出现的次数：" + num);
		
		
		
		
	    // 定义一个整型数组，长度为10
			int[] nums = new int[10];
	        
	        //通过循环给数组赋值
			for (int i = 0; i < nums.length; i++) {
	            // 产生10以内的随机数
				int x = (int) (Math.random()*10);
	            
				nums[i] = x;// 为元素赋值
			}
	        
			// 使用foreach循环输出数组中的元素
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
