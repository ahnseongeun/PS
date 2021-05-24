package DataStructure.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4
10 8
-7 9 2 -4 12 1 5 -3 -2 0
10 4
-7 9 2 -4 12 1 5 -3 -2 0
4 20
1 7 3 5
5 10
3 9 7 1 5
 */
/*
1
10 4
-7 -4 -3 -2 0 1 2 5 9 12
 */
public class 두수의합_9024 {

    private static int arr[];
    private static int getCount(int k, int n){

        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;
        int cnt = 1;
        while(left < right){
            int sum = arr[left] + arr[right];

            if(Math.abs(sum - k) < min){
                min = Math.abs(sum - k);
                cnt = 1;
            }else if(Math.abs(sum - k) == min){
                cnt++;
            }

            if(sum >= k){
                right--;
            }else{
                left++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        arr = new int[1000001];
        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(input.readLine());
            Arrays.fill(arr,100000001);
            for(int j = 0; j < n ; j++)
                arr[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            System.out.println(getCount(k, n));
        }
    }
}
