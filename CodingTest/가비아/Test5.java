package CodingTest.가비아;

import java.io.BufferedReader;

/*
dp[i] = dp[i - 2] + gold_prices[i];
2 5 1 3 4
 */
public class Test5 {
    public static void main(String[] args) throws Exception {
        int[] gold_prices = {2, 7};
        int size = gold_prices.length;
        int[] dp = new int[size];
        //dp[1] = Math.max(gold_prices[1] - gold_prices[0], 0);
        //dp[2] = Math.max(gold_prices[2] - gold_prices[1], dp[1]);
        //dp[3] = Math.max(gold_prices[3] - gold_prices[2], dp[2]);
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < i; j++) {
                if( gold_prices[i] - gold_prices[j] > 0 ) {
                      if( j >= 2 ) dp[i] = Math.max(dp[i], dp[j - 2] + gold_prices[i] - gold_prices[j]);
                      else dp[i] = dp[j - 2] + gold_prices[i] - gold_prices[j];
                }
            }
        }

        int max = 0;
        for(int i = 0; i < size; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
