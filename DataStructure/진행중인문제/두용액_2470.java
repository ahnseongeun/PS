package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
-2 4 -99 -1 98
5
-100 -50 20 40 80
 */

/**
 * 그냥 용액하나를 기준으로 잡고 차례대로 이분 탐색으로 통해서 진행해 나가는건 어때?
 */
public class 두용액_2470 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int min = Math.abs(arr[arr.length - 1] + arr[0]);
        int[] result = new int[2];
        result[0] = arr[0];
        result[1] = arr[arr.length - 1];

        int start = 0;
        int end = arr.length - 1;

        while(start < end) {

            int sum = arr[start] + arr[end];
            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                result[0] = arr[start];
                result[1] = arr[end];
            }

            if(sum < 0) {
                start++;
            } else {
                end--;
            }

        }

        System.out.println(result[0] + " " + result[1]);
    }
}
