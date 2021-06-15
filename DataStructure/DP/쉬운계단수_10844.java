package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쉬운계단수_10844 {

    private static long getCal(int n) {

        //dp[][] = index, 해당 index에 들어 있는 수 -> 몇개 가능한지
        long[][] dp = new long[101][10];
        for(int i = 1; i <= 9; i++)
            dp[1][i] = 1;

        //0 , 1, 2, 3, 4, 5, 6, 7, 8, 9
        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= 9; j++){
                //j가 0이라면
                if(j == 0) {
                    dp[i][j] = (dp[i - 1][1])% 1000000000;
                //j가 9라면
                }else if(j == 9) {
                    dp[i][j] = (dp[i - 1][8]) % 1000000000;
                    //나머지
                }else{
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }


        long sum = 0;
        for(int i = 0; i < 10; i++)
            sum = (sum + dp[n][i]) % 1000000000;

        return sum;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        System.out.println(getCal(n));
    }
}
