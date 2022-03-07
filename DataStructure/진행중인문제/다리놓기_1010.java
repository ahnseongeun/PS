package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3
2 2
1 5
13 29
 */
public class 다리놓기_1010 {

    static int MAX = 30;
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(input.readLine());
        int dp[][] = new int[MAX][MAX];
        for(int i = 0; i < MAX; i++) {
            for(int j = 0; j < MAX; j++) {
                if ( i == j || i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }
            }
        }
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(dp[n][m]).append("\n");
        }
        System.out.println(sb);
    }
}
