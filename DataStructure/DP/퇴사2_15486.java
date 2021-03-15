package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
 */
public class 퇴사2_15486 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int t[] = new int[n + 2];
        int p[] = new int[n + 2];
        int dp[] = new int[n + 2];

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        int maximum = 0;
        for(int i = 1; i <= n; i++){

            //dp 대신에 maximum으로 해줘야 하는 이유
            //dp에 값이 있는 것은 해당 index의 dp는 사용 가능 한 값이여서 거기중에서 최대 값을 고르는 방법은
            //매번 dp와 최대 값을 비교하면서 최대 값을 기록하고 있으면 된다.
            /**
             * dp[i]로 했을 경우 반례
             * 10
             * 5 50
             * 4 40
             * 3 30
             * 2 20
             * 1 10
             * 1 10
             * 2 20
             * 3 30
             * 4 40
             * 5 50
             */
            maximum = Math.max(maximum,dp[i]);

            // n + 1을 해줘야 하는 이유 i가 n이고 t[n] = 1 인 경우는 포함되는데 <=을 해주지 않으면 생략된다.
            if(i + t[i] <= n + 1){
                dp[i + t[i]] = Math.max(dp[i + t[i]],maximum + p[i]); //dp 대신에 maximum으로 해줘야 하는 이유
            }
        }

        int max = -1;
        for(int val : dp)
            max = Math.max(max, val);
        System.out.println(max);
    }
}
