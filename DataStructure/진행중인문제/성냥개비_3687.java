package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1. 최댓값은 짝수면 1로 채우고 홀수면 마지막 1만 7로 바꿔준다.
 * 2. 최솟값은 dp를 이용해야 하는데 먼저 성냥개비로 만들 수 있는 수 중에 최소 값을 담은 배열을 하나 만든다.
 * 3. 그이후 2개 ~ 7개로 만들 수 있는 모든 경우의 수 중에서 가장 작은 것은 dp에 넣는다.
 * 4. 이때 순서는 dp[i - j] 와 최소를 담은 배열[j]가 되어야 하는데 그 이유는 이미 최소인 dp에 최소인 수를 붙혀줘야 최소가 되기 때문이다.
 * 5. 맨 앞에 0이 올 때 6으로 바꿔주는 것을 조심하자.
 */
//값을 기준으로 dp를 만드는 것이 핵심이다.
public class 성냥개비_3687 {

    private static String[] dp;
    //minArr는 해당 성냥개비로 만들 수 있는 수중에서 최소 값이다.
    private static int[] minArr = {0,0,1,7,4,2,0,8};
    private static String maxCal(int num) {
        StringBuilder sb = new StringBuilder();
        int cnt = num / 2;
        num %= 2;
        for(int i = 0; i < cnt; i++)
            sb.append("1");
        if(num == 1){
            sb.replace(0,1,"7");
        }
        return sb.toString();
    }

    private static void minCal() {
        dp[2] = "1";
        dp[3] = "7";
        dp[4] = "4";
        dp[5] = "2";
        dp[6] = "0";
        dp[7] = "8";
        for(int i = 8; i <= 100; i++){ //dp index
            for(int j = 2; j <= 7 ; j++){ //다음 dp의 최대 값 구하기
                StringBuilder st = new StringBuilder();
                st.append(dp[i - j]).append(minArr[j]);
                //왜 dp[i -j] 와 minArr 순이여야 할까?
                //도대체 왜?... 최소가 만들어 진 것에 뒤에 붙이는 것이 가장 최소가 되는 것 아닐까?
                if(st.charAt(0) == '0')
                    st.replace(0,1,"6");
                long tmp = Math.min(Long.parseLong(dp[i]),Long.parseLong((st.toString())));

                dp[i] = String.valueOf(tmp);
            }
            System.out.println(dp[i]);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        dp = new String[111];
        Arrays.fill(dp,"9999999999999999");

        minCal();
        dp[6] = "6";
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(input.readLine());
            sb.append(dp[num]).append(" ").append(maxCal(num)).append("\n");
        }
        System.out.println(sb);
    }
}
