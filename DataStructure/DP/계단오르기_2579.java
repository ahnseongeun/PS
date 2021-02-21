package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 계단오르기_2579 {
    public static void main(String[] args) throws Exception{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int arr[] = new int[n + 1];
        int dp[] = new int[n + 1];
        for(int i = 1 ; i <= n; i++)
            arr[i] = Integer.parseInt(input.readLine());

        dp[1] = arr[1];
        if(n > 1) {
            dp[2] = dp[1] + arr[2];

            for (int i = 3; i <= n; i++) {
                int compare1 = dp[i - 2] + arr[i];
                int compare2 = dp[i - 3] + arr[i - 1] + arr[i];
                dp[i] = Math.max(compare1, compare2);
            }
        }
        //System.out.println(Arrays.toString(Arrays.stream(dp).toArray()));
        System.out.println(dp[n]);
    }
}
