package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
 */

/**
 * DP의 문제이고 N (1 ≤ N ≤ 15) 값을 범위가 15까지 밖에없어서 O(n^2)으로 해결 가능하다.
 */
public class 퇴사_14501 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int arr[][] = new int[n + 2][n + 2];
        int dp[] = new int[n + 2];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n + 1;i++){
            for(int j = 1; j < i; j++){
                if(i - j >= arr[j][0]){
                    dp[i] = Math.max(dp[j] + arr[j][1],dp[i]);
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
