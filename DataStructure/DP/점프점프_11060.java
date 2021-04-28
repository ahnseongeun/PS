package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
10
1 2 0 1 3 2 1 5 4 2
 */

/**
 * 음... j + arr[j] < i
 * dp[i] =
 */
public class 점프점프_11060 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int arr[] = new int[n];
        int dp[] = new int[n];
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            dp[i] = 10000;
            for(int j = 0; j < i; j++){
                int jump = arr[j];
                for(int k = 1; k <= jump; k++){
                    if(j + k == i){
                        dp[i] = Math.min(dp[i - k] + 1,dp[i]);
                    }
                }
            }
        }

//        StringBuilder sb = new StringBuilder();
//        Arrays.stream(dp).forEach(value -> sb.append(value + " "));
//        System.out.println(sb);
        System.out.println(dp[n - 1] == 10000 ? -1 : dp[n - 1]);

    }
}
