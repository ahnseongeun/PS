package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FourSquares {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        int[] dp = new int[50001];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 1; i <= 50000; i++) {
            for(int j = 1; j <= Math.sqrt(i); j++) {
                if(i - (j * j ) >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
                }
            }
        }

        System.out.println(dp[n]);
    }
}
