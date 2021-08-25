package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
긴 순서대로 사이의 값이 1이 아니라면 제거 1이라면 stay
8
1 8
3 9
2 2
4 1
6 4
10 10
9 7
7 6
3
1 1
2 2
3 3
 */

/**
 * 1. 왼쪽 전깃줄을 기준으로 오름차순으로 정렬을 한다.
 * 2. 오른쪽 전깃줄에서 가장 긴 증가하는 수열을 찾는다.
 * 3. 전체 N - (수열의 길이)가 정답이다.
 */
public class 전깃줄_2565 {
    public static void main(String[] args) throws Exception {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] dp = new int[501];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new int[]{start, end});
        }

        int size = pq.size();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) arr[i] = Objects.requireNonNull(pq.poll())[1];

        Arrays.fill(dp, 1);
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);
    }
}


















