package DataStructure.DP;

/*
3 3
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이 문제의 핵심은 최대 시간 복잡도는 N 30, a 30, b 30 , p 30 -> 30^3 * (30 * 29 / 2) , 대략 천만이다.
 * N은 문자열의 길이, a는 A의 개수, b는 B의 개수, p는 순서쌍의 개수이다.
 * c의 개수는 N - a - b로 구할 수 있어서 굳이 저장을 안시켜도 된다.
 * A를 뒤에 붙히는 경우 dp[i + 1][a + 1][b][p] = 1
 * B를 뒤에 붙히는 경우 dp[i + 1][a][b + 1][p + a] = 1
 * C를 뒤에 붙히는 경우 dp[i + 1][a][b][p + a + b] = 1
 */
public class ABC_12969 {

    private static int n, k;
    private static char arr[];
    private static boolean flag = false;
    private static StringBuilder sb = new StringBuilder();

    private static void calculationPair(int idx, int a, int b, int p, int[][][][] dp) {

        if(idx == n){
            if(p == k && !flag) {
                for (char ch : arr)
                    sb.append(ch);
                flag = true;
            }
            return ;
        }

        //A를 뒤에 붙히는 경우
        if(dp[idx + 1][a + 1][b][p] == 0) {
            arr[idx] = 'A';
            dp[idx + 1][a + 1][b][p] = 1;
            calculationPair(idx + 1, a + 1, b, p, dp);
        }

        //B를 뒤에 붙히는 경우
        if(dp[idx + 1][a][b + 1][p + a] == 0) {
            arr[idx] = 'B';
            dp[idx + 1][a][b + 1][p + a] = 1;
            calculationPair(idx + 1, a, b + 1, p + a, dp);
        }

        //C를 뒤에 붙히는 경우
        if(dp[idx + 1][a][b][p + a + b] == 0) {
            arr[idx] = 'C';
            dp[idx + 1][a][b][p + a + b] = 1;
            calculationPair(idx + 1, a, b, p + a + b, dp);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int dp[][][][] = new int[31][31][31][500];
        arr = new char[n];

        dp[0][0][0][0] = 1;
        calculationPair(0,0,0,0,dp);
        if(flag){
            System.out.println(sb.toString());
        }else{
            System.out.println(-1);
        }

    }
}
