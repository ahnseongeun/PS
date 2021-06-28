package DataStructure.DP;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
5 60
30 10 20 35 40
3 0 3 5 4
 */

/**
 * 최소 비용 cost를 가지고 M이상을 만족시키는 방법을 찾아라.
 * 모든 경우의 수는 2^100 -> 줄이는 방법을 생각해보자.
 * 비용이 x라고 하면 dp[x] = dp[x - cost] + memory, dp[x]
 * dp배열의 최대 크기는 모든 가중치 c의 값을 더한 값이다.
 * 배열의 최대 크기는 가중치가 100일 때 100 * 100으로 10000이다.
 */
public class 앱_7579 {

    private static int n;
    private static int m;
    private static int[][] arr;
    private static int getMinMemory(int sum) {

        int result = 0;
        int[] dp = new int[sum + 1];
        for(int i = 0; i < n; i++){
            for(int j = sum; j >= arr[i][1]; j--){
                dp[j] = Math.max(dp[j],dp[j - arr[i][1]] + arr[i][0]);
            }
        }


        for(int i = 0 ; i <= sum; i++){
            if(dp[i] >= m){
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][2];

        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++) arr[i][0] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());
        int sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
            sum += arr[i][1];
        }
        System.out.println(getMinMemory(sum));

    }
}
