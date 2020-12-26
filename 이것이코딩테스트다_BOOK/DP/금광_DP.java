package 이것이코딩테스트다_BOOK.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * dp[j][i]=Math.max(dp[j][i],dp[j-1][i-1]+arr[j][i]);
 * dp[j][i]=Math.max(dp[j][i],dp[j][i-1]+arr[j][i]);
 * if(j!=n)
 *    dp[j][i]=Math.max(dp[j][i],dp[j+1][i-1]+arr[j][i]);
 *
 * 2
 * 3 4
 * 1 3 3 2 2 1 4 1 0 6 4 7
 * 4 4
 * 1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
 */
public class 금광_DP {
    private static int[][] fillArray(int n, int m, int[][] arr, StringTokenizer st) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        return arr;
    }

    private static int MaxArray(int n, int m, int[][] arr) {
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=arr[i][j];
            }
        }
        for(int i=2;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[j][i]=Math.max(dp[j][i],dp[j-1][i-1]+arr[j][i]);
                dp[j][i]=Math.max(dp[j][i],dp[j][i-1]+arr[j][i]);
                if(j!=n)
                    dp[j][i]=Math.max(dp[j][i],dp[j+1][i-1]+arr[j][i]);
            }
        }
        return maxSearch(n,m,dp);
    }

    private static int maxSearch(int n,int m,int dp[][]){
        int max=dp[1][1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t = Integer.parseInt(input.readLine());
        for(int i=0;i<t;i++){
            StringTokenizer st=new StringTokenizer(input.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(input.readLine());
            int arr[][]=new int[n+1][m+1];
            arr = fillArray(n,m,arr,st);
            sb.append(MaxArray(n,m,arr)+"\n");
        }
        System.out.println(sb);

    }
}
