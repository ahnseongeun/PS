package DataStructure.다시풀어야하것;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
팰린드롬을 구하기 위해 가장 최소가 되는 삽입을 구하는 방법
팰린드롬의 정의는 앞에서 읽었을 때와 뒤에서 읽었을 때 같은 수열을 말하는 것이다.
수열 1 2 3 5 2 가 있다고 하자.
핵심은 전체 수열의 크기에서 짝을 이루지 않는 수열의 차이를 빼는 것이다.
1 2 3 5 2 -> 5 - 3 = 2 즉, 최소한 채워넣어야 하는 삽입의 개수는 2개이다.
x o o x o
그러면 짝을 이루는 수열을 탐색하는 가장 좋은 방법은 무엇이 있을까??
바로 문자열을 뒤집어서 LCS(최장 공통수열을 구하는 것)를 구하는 것이다.
1 2 3 5 2
2 5 3 2 1
 */
public class 팰린드롬_1695 {

    private static int[] arr;
    private static int[] reverse_arr;
    private static int[][] dp;

    private static int getLCS() {
        int result = 0;
        for(int i = 1; i <= arr.length; i++){
            for(int j = 1; j <= reverse_arr.length; j++){
                if(arr[i - 1] == reverse_arr[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
                result = Math.max(result,dp[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        arr = new int[n];
        reverse_arr = new int[n];
        dp = new int[n + 1][n + 1];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            reverse_arr[n - 1 - i] = arr[i];
        }
        //arr과 reverse_arr의 LCS를 구하자.
        //System.out.println(getLCS());
        System.out.println(n - getLCS());
//        StringBuilder sb = new StringBuilder();
//        Arrays.stream(dp).forEach(value -> sb.append(value + " "));
//        System.out.println(sb);

    }
}
