package DataStructure.미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한수_1065 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(input.readLine());
		int result=0;
		if(n<100) {
			result=n;
		}else {
			result=99;
			for(int i=100;i<=n;i++) {
				int num1=i/100;
				int num2=i/10%10;
				int num3=i%10;
				if(num1-num2==num2-num3)
					result++;	
			}
		}
		
		System.out.println(result);
		// TODO Auto-generated method stub

	}

}
