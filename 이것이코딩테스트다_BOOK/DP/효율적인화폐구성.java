package 이것이코딩테스트다_BOOK.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 먼저 최대가 되는 것을 채우고
 * 더 최소가 되는 조건을 만족하면 최소로 바꾼다.
 */
public class 효율적인화폐구성 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        StringBuilder sb;
        int n=Integer.parseInt(st.nextToken());
        int target=Integer.parseInt(st.nextToken());
        int coins[]=new int[n];
        int dp[]=new int[target+1];
        for(int i=0;i<n;i++) {
            coins[i] = Integer.parseInt(input.readLine());
        }
        Arrays.fill(dp,10001);
        dp[0]=0; //dp[0]=0을 기준으로 쌓아가는 것이 중요포인트이다.
        for(int i=0;i<coins.length;i++){ //작은 코인부터 쌓아간다.
            for(int j=coins[i];j<=target;j++){
                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
            sb=new StringBuilder();
            for(int k:dp)
                sb.append(k+" ");
            System.out.println(sb);
        }

        System.out.println(dp[target]==10001?-1:dp[target]);
    }
}
