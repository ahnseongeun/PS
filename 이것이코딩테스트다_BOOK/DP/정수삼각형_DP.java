package 이것이코딩테스트다_BOOK.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
 */
public class 정수삼각형_DP {

    private static void display(int n, int[][] dp) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                sb.append(dp[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int maxSearch(int[][] arr, int[][] dp, int n) {
        dp[1][1]=arr[1][1];
        int max=0;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i][j]=(arr[i][j]+Math.max(dp[i-1][j-1],dp[i-1][j]));
                if(i==n)
                    max=Math.max(max,dp[i][j]);
            }
        }
        display(n,dp);
        return max;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(input.readLine());
        StringTokenizer st;
        int arr[][]=new int[n+1][n+1];
        int dp[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(input.readLine());
            for(int j=1;j<=i;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(maxSearch(arr,dp,n));
    }
}
