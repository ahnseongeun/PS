package DataStructure.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
-2 6 -97 -6 98
 */

/**
 * 순열이 아니라 조합의 관계 이기 때문에 i를 기준으로 j는 최소 i + 1이다.
 */
public class 세용액_2473 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        long[] arr = new long[n];
        for(int i = 0; i < n; i++ ) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        //첫번째 용액
        long min = 9999999999L;
        long[] result = new long[3];

        for(int i = 0; i < n - 2; i++) {

            int start = i + 1;
            int end = n - 1;

            while(start < end) {

                long sum = arr[i] + arr[start] + arr[end];

                if(Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    result[0] = arr[i];
                    result[1] = arr[start];
                    result[2] = arr[end];
                }


                if(sum < 0) start++;
                else end--;
            }

        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(result);
        sb.append(result[0]).append(" ").append(result[1]).append(" ").append(result[2]);
        System.out.println(sb);
    }
}
