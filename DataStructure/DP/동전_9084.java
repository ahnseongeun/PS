package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3
2
1 2
1000
3
1 5 10
100
2
5 7
22
 */
public class 동전_9084 {

    private static int getTargetCount(int[] arr, int[] dp, int n, int target) {

       for(int i = 0; i < n; i++){ //arr길이 만큼
           for(int j = arr[i]; j <= target; j++){ //target dp[j - arr[i]]만큼 더해주기
               dp[j] += dp[j - arr[i]];
           }
       }
       return dp[target];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(input.readLine());
        for(int i = 0; i < num; i++){
            int n = Integer.parseInt(input.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++) arr[j] = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(input.readLine());
            int[] dp = new int[target + 1];
            dp[0] = 1;
            sb.append(getTargetCount(arr,dp,n,target)).append("\n");
        }
        System.out.println(sb);
    }
}
