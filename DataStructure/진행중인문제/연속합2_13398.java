package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다.
수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
10
10 -4 3 1 5 6 -35 12 21 -1
 */
public class 연속합2_13398 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        /*
        내가 생각한 풀이는 먼저 제거하지 않는 dp 1, 제거하는 dp 2 이렇게 누적합을 구한다.
        dp[i] = 제거한 dp 와 제거하지 않은 dp 중 큰 것을 삽입한다.
         */
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][2]; //0은 제거하지 않았을때, 1은 제거 했을 때
        int max = -1001;
        //최소 한개를 선택 해야한다.
        dp[0][0] = -1001;
        dp[0][1] = -1001;
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            //삭제하지 않는 dp랑 삭제한 dp중에 고르기
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i],arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            max = Math.max(max,Math.max(dp[i][0],dp[i][1]));
        }
        System.out.println(max);
    }
}
