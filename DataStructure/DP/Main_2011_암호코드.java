package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1<= n <= 5000
public class Main_2011_암호코드 {

	public static void main(String[] args) throws Exception{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String str= input.readLine();
		int n=str.length();
		int arr[]=new int[n];
		int dp[]=new int[n];
		int result=-1;
		for(int i=0;i<n;i++) {
			arr[i] = str.charAt(i) - '0';
			if(arr[i]==0) //암호 해독 안되는 경우
				result=0;
		}

		dp[0]=1;
		if(result==0){
			System.out.println(result);
		}else{
			for(int i=1;i<n;i++){
				int num=(arr[i-1]*10+arr[i]);
				if(num<26&&num>=10){
					dp[i]=(dp[i-1]*2)%1000000;
				}else{
					dp[i]=(dp[i-1])%1000000;
				}
				System.out.println(i+" "+dp[i]);
			}
			System.out.println(dp[n-1]);
		}

	}

}
