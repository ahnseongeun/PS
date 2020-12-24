package 이것이코딩테스트다_BOOK.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 바닥공사_DP {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(input.readLine());
        int dp[]=new int[1001];
        dp[1]=1;
        dp[2]=3;
        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2]*2)%796796;
        }
        System.out.println(dp[n]);
    }
}
