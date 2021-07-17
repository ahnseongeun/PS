package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * dp를 푸는 방법
 * 1. dp 정의
 * - dp[i][j] i~j까지 가장 긴 유전자 문자열 길이
 * 2. 점화식 세우기
 * - 1번 조건 : X가 KOI라면 aXt, gXc 이다.
 *      - dp[i + 1][j - 1] +2
 * - 2번 조건 : X,Y가 KOI라면  XY도 KOI이다.
 *      - dp[i][k] + dp[k + 1][j]
 * 3. 문제 적용
 * 최대 N^2이므로 500 * 500
 *
 */
/*
acattgagtc
 */
public class 유전자_2306 {

    private static int[][] dp;
    private static char[] str;


    private static int getMaxLen(int start, int end) {

        if(start >= end) return 0;
        if(dp[start][end] != -1) return dp[start][end];

        //3번 조건 : X,Y가 KOI라면  XY도 KOI이다.
        for(int k = start; k < end; k++) {
            dp[start][end] = Math.max(dp[start][end], getMaxLen(start, k) + getMaxLen(k + 1, end));
        }

        //2번 조건 : X가 KOI라면 aXt, gXc 이다.
        if(str[start] == 'a' && str[end] == 't' || str[start] == 'g' && str[end] == 'c')
            dp[start][end] = Math.max(dp[start][end], getMaxLen(start + 1, end - 1) + 2);

        return dp[start][end];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        str = input.readLine().toCharArray();
        dp = new int[501][501];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        System.out.println(getMaxLen(0, str.length - 1));
    }
}
