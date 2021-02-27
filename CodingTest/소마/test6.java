package CodingTest.소마;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test6 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = n -1;
        int sum = 0;
        while(start < end){
            int mid = (start+end)/2;
            int left_max = -1;
            for(int i = start; i <= mid; i++){
                left_max = Math.max(left_max,arr[i]);
            }
            int right_max = -1;
            for(int i = mid + 1; i <= end; i++){
                right_max = Math.max(right_max,arr[i]);
            }
            if(left_max > right_max){
                sum += left_max;
                start = mid + 1;
            }else{
                sum += right_max;
                end = mid - 1;
            }
        }
        System.out.println(sum);
    }
}
