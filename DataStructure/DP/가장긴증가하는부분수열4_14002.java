package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/*
6
10 20 1 2 3 4
3
3 3 1
7
1 6 2 4 5 3 7
 */
public class 가장긴증가하는부분수열4_14002 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int arr[] = new int[n + 1];
        int dp[] = new int[n + 1];
        int track[] = new int[n + 1];

        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            int value = arr[i];
            for(int j = 0; j < i; j++){
                if(arr[j] < value && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    track[i] = j;
                }
            }
        }

        //max 구하기
        int idx = 0;
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(dp[i] > dp[idx]){
                idx = i;
                max = dp[i];
            }
        }
        //backtracking 진행

        StringBuilder sb = new StringBuilder();
        System.out.println(max);
        while(idx != 0){
            sb.insert(0,arr[idx]+" ");
            idx = track[idx];
        }
        System.out.println(sb);


    }
}
