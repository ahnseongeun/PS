package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
20
3
5 3
10 2
1 5
 */

/**
 * 타겟이 있고 동전의 크기와 동전의 사이즈가 있을 경우 어떻게 해결 할 것인가?
 * 각각의 코인 개수로 만들 수 있는 경우의 수를 dp에 누적해가면서 답을 구할 수 있다.
 */
public class 동전바꿔주기_2624 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine()); //목표 금액
        int n = Integer.parseInt(input.readLine()); //코인의 개수
        int[][] coins = new int[n + 1][2];
        int[] dp = new int[t + 1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            coins[i][0] = Integer.parseInt(st.nextToken());
            coins[i][1] = Integer.parseInt(st.nextToken());
        }

        //코인의 수
        for(int i = 1; i <= n; i++) {
            int coin = coins[i][0];
            int count = coins[i][1];
            //해당 코인의 개수
            for(int j = t; j >= coin; j--) {
                for(int k = 1; k <= count; k++) {
                    int value = j - (coin * k);
                    if(value < 0) break;
                    dp[j] += dp[value];
                }
            }
            display(dp);
        }

        System.out.println(dp[t]);
    }

    static void display(int[] dp) {

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < dp.length; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }
}

