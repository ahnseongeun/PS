package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
6
10 20 10 30 20 50
2
20 10
6
10 100 20 10 20 30
0 1  2   2  2  2  3
10 60 30 20 50 80 100
arr[i] > arr[i - 1]
dp[i] = dp[i - 1] + 1;
dp는 뒤에서 부터 생각하자
arr[i] >= dp[i - 1]
dp[i] = arr[i];

 */
public class 가장긴증가하는수열_11053 {
    public static void main(String[] args) throws Exception{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int arr[] = new int[n + 1];
        int dp[] = new int[n + 1];
        for(int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= i; j++){
                if(arr[i] > arr[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
