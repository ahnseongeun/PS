package 이것이코딩테스트다_BOOK.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 현재 N에 대해서 독립적으로 생각하고
 * 이전까지의 계산과정을 이용한다기 보다 결과값을 이용해서 구하는 방법으로 생각해야한다.
 */
public class 개미전사 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(input.readLine());
        int dp[]=new int[n+1];
        int arr[]=new int[n+1];
        StringTokenizer st=new StringTokenizer(input.readLine());
        for(int i=1;i<=n;i++)
            arr[i]=Integer.parseInt(st.nextToken());
        dp[1]=arr[1];
        dp[2]=Math.max(arr[1],arr[2]);
        for(int i=3;i<=n;i++){
            //dp[i]=Math.max((dp[i-2]+arr[i]),(dp[i-3]+arr[i]));
            dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i]);
        }
        System.out.println(dp[n]);
    }
}
