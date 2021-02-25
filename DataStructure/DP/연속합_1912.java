package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연속합_1912 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int arr[] = new int[n];
        int dp[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dp[0] = arr[0];

        for(int i = 1; i < n ; i++){
            dp[i] = Math.max(dp[i - 1] + arr[i],arr[i]);
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}
