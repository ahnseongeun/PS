package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
10 15
5 1 3 5 10 7 4 9 2 8
 */
public class 부분합_1806 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        long sum = 0;
        int left = 0;
        int right = 0;
        int len = 0;
        long result = Long.MAX_VALUE;
        while(left != n) {

            if(right == n){
                if(sum >= target) result = Math.min(result, len);
                sum -= arr[left];
                left++;
                len--;
                continue;
            }
            if(sum < target) {
                sum += arr[right];
                right++;
                len++;
            } else if ( sum >= target ) {
                result = Math.min(result, len);
                sum -= arr[left];
                len--;
                left++;
            }
        }

        System.out.println(result == Long.MAX_VALUE ? 0 : result);
    }
}
