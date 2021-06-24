package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
3
1 2 3
4 5 6
4 9 0
 */
public class 내려가기_2096 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        int[][] map = new int[n + 1][4];
        int[][] dp = new int[n + 1][4];
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 1; j <= 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= n; i++){
            dp[i][1] = Math.max(map[i][1] + dp[i - 1][1],map[i][1] + dp[i - 1][2]);
            dp[i][2] = Math.max(Math.max(map[i][2] + dp[i - 1][1],map[i][2] + dp[i - 1][2]),map[i][2] + dp[i - 1][3]);
            dp[i][3] = Math.max(map[i][3] + dp[i - 1][2],map[i][3] + dp[i - 1][3]);
        }
        sb.append(Math.max(Math.max(dp[n][1],dp[n][2]),dp[n][3])).append(" ");

        for(int i = 1; i <= n; i++){
            Arrays.fill(dp[i],0);
            dp[i][1] = Math.min(map[i][1] + dp[i - 1][1],map[i][1] + dp[i - 1][2]);
            dp[i][2] = Math.min(Math.min(map[i][2] + dp[i - 1][1],map[i][2] + dp[i - 1][2]),map[i][2] + dp[i - 1][3]);
            dp[i][3] = Math.min(map[i][3] + dp[i - 1][2],map[i][3] + dp[i - 1][3]);
        }
        sb.append(Math.min(Math.min(dp[n][1],dp[n][2]),dp[n][3]));
        System.out.println(sb);
    }
}
