package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
10 5
1 2 3 4 2 5 3 1 1 2
 */
public class 수들의합_2003 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        while(start != n) {

            if(end == n) {
                if( sum == target) count++;
                sum -= arr[start++];
                continue;
            }

            if(sum > target) {
                sum -= arr[start++];
            } else if(sum == target) {
                count++;
                sum += arr[end++];
            } else {
                sum += arr[end++];
            }
        }

        System.out.println(count);
    }
}
