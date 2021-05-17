package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
4
5
00 1을 사용할 수 있다.
1- 1 1  1
2- 00 11 1 2
3- 001 100 111 1 3
4- 0000 1100 0011 //  1001 1111 2 5
5- 00001 00100 10000 00111 11100 // 11001 10011 11111 3 6

 */
public class 공일타일_1904 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n ; i++){
            dp[i] = ((dp[i - 1] % 15746) + (dp[i - 2] % 15746))  % 15746;
        }
        System.out.println(dp[n]);
    }
}
