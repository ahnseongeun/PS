package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 어떤 방식이 있을까??
 * 한번에 구하는 방식이 아닌 이전 부터 쌓아오는 방식을 사용해야한다.
 * 생각을 해보자..
 * 1. dp를 초기화 하자.
 * 2. dp[x][y] = dp[x][y - 1] + dp[x - 1][y]를 만족한다.
 * 3. dp[n][m]에서 부터 백트래킹을 통해서 문자열을 완성한다.
 */
/*
2 2 2
 */
public class 사전_1256 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken()); //a의 개수
        int m = Integer.parseInt(st.nextToken()); //z의 개수
        int k = Integer.parseInt(st.nextToken()); //target의 index
        int[][] dp = new int[101][101]; //a의 개수와, z의 개수로 dp 설정


        for(int i = 1; i <= 100; i++) {
            dp[0][i] = 1;
            dp[i][0] = 1;
        }

        //dp 채우기
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]);
                dp[i][j] = Math.min(dp[i][j],1000000000);
            }
        }


        int a_count = n;
        int z_count = m;
        //백트래킹 진행,  dp[n][m]는 총 index의 개수

        if(dp[n][m] < k) {
            sb.append(-1);
        } else {

            //어떤 식으로 백트래킹을 진행해야 할까??
            //a_count와 z_count를 하나씩 차감 시키는데 어떤 기준으로 a와 z를 정할까??
            //k는 target인데 target보다 크다면 a이고 target보다 작다면 z이다.
            for(int i = 1; i <= n + m; i++) {

                if(a_count == 0) {
                    z_count --;
                    sb.append("z");
                    continue;
                }

                if(z_count == 0) {
                    a_count --;
                    sb.append("a");
                    continue;
                }
                //현재의 a_value를 구한다.
                int a_value = dp[a_count - 1][z_count];
                int z_value = dp[a_count][z_count - 1];


                //k보다 a_value가 크다는 것은 현재값은 a라는 뜻
                if( k <= a_value) {
                    a_count--;
                    sb.append("a");
                } else {
                    k -= a_value;
                    z_count--;
                    sb.append("z");
                }
            }
        }

        System.out.println(sb);
    }
}
