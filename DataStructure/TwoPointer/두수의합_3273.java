package DataStructure.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
9
5 12 7 10 9 1 2 3 11
13
 */
public class 두수의합_3273 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for( int i = 0; i < n; i++ ) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int target = Integer.parseInt(input.readLine());
        int count = 0;
        int start = 0;
        int end = n - 1;
        while(start < end) {
            int sum = arr[start] + arr[end];
            if( sum > target) {
                end--;
            } else if( sum == target) {
                count++;
                start++;
            } else {
                start++;
            }
        }
        System.out.println(count);

    }
}
