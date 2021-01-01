package 이것이코딩테스트다_BOOK.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
7
15 11 4 8 5 2 4

7
1 2 3 100 10 2 1

6
1 2 1 3 2 5
 */

/**
 * DP, 이분 탐색으로도 풀수 있는듯?
 */
public class 병사배치하기_DP {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(input.readLine());
        StringTokenizer st=new StringTokenizer(input.readLine());
        int arr[]=new int[n+1];
        int dp[]=new int[n+1];

        for(int i=1;i<=n;i++) { //배열에 값 넣기
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,1);
        int max=0;
        for(int i=1;i<=n;i++){ //n-1까지
            for(int j=1;j<=i;j++){
                    if(arr[i]<arr[j]){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
            }
            max=Math.max(dp[i],max);
        }
        System.out.println(n-max);
//        StringBuilder sb=new StringBuilder();
//        for(int i=1;i<=n;i++){
//            sb.append(dp[i]+" ");
//        }
//        System.out.println(sb);
    }
}
