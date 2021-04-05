package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
7
3
7
5
2
6
1
4
 */

/**
 * 이미 오름 차순으로 정렬되어 있는 것을 뼈대로 잡아서 나머지 원소들만 SWAP하면 문제가 해결된다는 것을 배웠다.
 */
public class 줄세우기_2631 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(input.readLine());

        for(int i = 1; i <= n; i++){
            for(int j = 0 ; j <= i; j++){
                if(arr[i] > arr[j] && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
            }
        }

        System.out.println(n - Arrays.stream(dp).max().getAsInt());

//        sb = new StringBuilder();
//        Arrays.stream(dp).filter(value -> value != 0).forEach(value -> sb.append(value + " "));
//        System.out.println(sb);
    }
}
